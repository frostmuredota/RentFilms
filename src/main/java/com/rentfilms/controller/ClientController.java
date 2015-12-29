package com.rentfilms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import com.rentfilms.dao.MovieDao;
import com.rentfilms.dao.ClientDao;
import com.rentfilms.model.Actor;
import com.rentfilms.model.Client;
import com.rentfilms.model.Movie;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientDao dao;


	final static Logger logger = Logger.getLogger(ClientController.class);


	@RequestMapping(value = "/create")
	public ModelAndView viewClient() {
		ModelAndView view = new ModelAndView();
		view.setViewName("create");
		return view;

	}
	@RequestMapping(value="/createclient" , method = POST)
	@ResponseBody
	public ResponseEntity< Client> createClient(@RequestBody Client client){
		
		Client clientFound = dao.findByRut(client.getRut());
		
		if(clientFound==null){
			dao.save(client);
			return new ResponseEntity<Client>(client,OK);
		}else{
			return new ResponseEntity<Client>(NOT_ACCEPTABLE);
		}
 
	}

	@RequestMapping(value = "/get/{id}", method = GET)
	@ResponseBody
	public Client getClient(@PathVariable(value = "id") int id) {
		return dao.findOne(id);
	}

	@RequestMapping(value = "/actor")
	@ResponseBody
	public Actor getActor() {
		Actor a = new Actor();
		return a;
	}

	@RequestMapping(value = "/myclients", method = {GET,POST})
	public ModelAndView showAllMyClients() {
		logger.debug("Showing client list");
		System.out.println("AQUI TAMO");
		ModelAndView view = new ModelAndView();
		view.setViewName("clients");
		view.addObject("listmyclients", dao.allMyClients());
		return view;
	}

	@RequestMapping(value = "/delete/{id}", method = GET)
	public ModelAndView deleteClient(@PathVariable(value = "id") int id) {
		dao.delete(id);
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:"+"/clients/myclients");
		return view;
	}

	@RequestMapping(value = "/update", method = PUT, consumes = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Client> updateClient(@RequestBody Client client) {
		logger.debug("Start Update");
		Client cliente = dao.findOne(client.getId());
		cliente.setRut(client.getRut());
		cliente.setEmail(client.getEmail());
		cliente.setLastName(client.getLastName());
		cliente.setFirstName(client.getFirstName());
		dao.saveAndFlush(cliente);
		logger.debug("Update successfull");
		return new ResponseEntity<Client>(OK);
	}

}
