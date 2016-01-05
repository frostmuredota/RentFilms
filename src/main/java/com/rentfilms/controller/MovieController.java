package com.rentfilms.controller;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rentfilms.dao.MovieDao;
import com.rentfilms.model.Client;
import com.rentfilms.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieDao movieDao;
	
	
	@RequestMapping(value = "/create")
	public ModelAndView viewMovie() {
		ModelAndView view = new ModelAndView();
		view.setViewName("createmovie");
		return view;

	}
	@RequestMapping(value="/createmovie" , method = POST)
	@ResponseBody
	public ResponseEntity< Movie> createMovie(@RequestBody Movie movie){
		
		Movie movieFound = movieDao.findByName(movie.getNameMovie());
		
		if(movieFound==null){
			movieDao.save(movie);
			return new ResponseEntity<Movie>(movie,OK);
		}else{
			return new ResponseEntity<Movie>(NOT_ACCEPTABLE);
		}
 
	}

	@RequestMapping(value = "/get/{id}", method = GET)
	@ResponseBody
	public Movie getMovie(@PathVariable(value = "id") int id) {
		return movieDao.findOne(id);
		
	}

	@RequestMapping(value = "/mymovies", method = {GET,POST})
	public ModelAndView showAllMyMovies() {
		ModelAndView view = new ModelAndView();
		view.setViewName("movies");
		view.addObject("listmymovies", movieDao.allMyMovies());
		return view;
	}

	@RequestMapping(value = "/delete/{id}", method = GET)
	public ModelAndView deleteClient(@PathVariable(value = "id") int id) {
		movieDao.delete(id);
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:"+"/movies/mymovies");
		return view;
	}

	@RequestMapping(value = "/update", method = PUT, consumes = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie m) {

		Movie movie = movieDao.findOne(m.getId());
		movie.setNameMovie(m.getNameMovie());;
		movie.setDuration(m.getDuration());
		movieDao.saveAndFlush(m);
		return new ResponseEntity<Movie>(OK);
	}
}
