package com.rentfilms.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rentfilms.dao.ClientDao;
import com.rentfilms.dao.MovieDao;
import com.rentfilms.model.Client;
import com.rentfilms.model.Movie;
import com.rentfilms.model.Rent;


@RestController
public class RentController {
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private MovieDao movieDao;
	
	@RequestMapping(value = {"/","/index"})
	public ModelAndView index() {
		ModelAndView index = new ModelAndView();
		index.setViewName("index");
		return index;
	}

	
	@RequestMapping(value="/rent")
	public ModelAndView viewRent(){
		ModelAndView view = new ModelAndView();
		view.setViewName("createrent");
		view.addObject("clientlist", clientDao.allMyClients());
		view.addObject("movielist", movieDao.allMyMovies());
		return view;
	}

	
	@RequestMapping(value="/rentmovie" , method = POST, consumes = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object>createRent(@RequestBody Rent rent){
		
		Client foundClient = clientDao.findByNameAndLastName(rent.getNameClient(), rent.getLastNameClient());
		Movie foundMovie = movieDao.findByName(rent.getNameMovie());
		
		
		if(foundClient!=null && foundMovie!=null){
			
			if(foundClient.getMyrents().contains(foundMovie)){

				return new ResponseEntity<Object>(NOT_ACCEPTABLE);
			}else{
;
			  foundClient.getMyrents().add(foundMovie) ;
			  clientDao.saveAndFlush(foundClient);
			  return new ResponseEntity<Object>(OK);
			}
						
		}else{

			return new ResponseEntity<Object>(NOT_FOUND);
		}
		
	}
	

	@RequestMapping(value="/myrents")
	public ModelAndView myRents(){
		ModelAndView view = new ModelAndView();
		view.setViewName("rents");
		view.addObject("clientlist", clientDao.findAll());
		view.addObject("rentlist", clientDao.allMyRents());
		return view;
	}
	
	@RequestMapping(value="/delete/{idClient}/{idMovie}",method = DELETE)
	public ResponseEntity<Client> deleteRent(@PathVariable("idClient") int idClient, @PathVariable("idMovie") int idMovie){
		Client foundClient = clientDao.findOne(idClient);
		Movie foundMovie = movieDao.findOne(idMovie);
		
		
		if(foundClient!=null && foundMovie!=null){
			
			if(foundClient.getMyrents().contains(foundMovie)){
                foundClient.getMyrents().remove(foundMovie);
                clientDao.saveAndFlush(foundClient);
				return new ResponseEntity<Client>(OK);
			}else{

			  return new ResponseEntity<Client>(NOT_FOUND);
			}
						
		}else{

			return new ResponseEntity<Client>(NOT_ACCEPTABLE);
		}
	}
}



