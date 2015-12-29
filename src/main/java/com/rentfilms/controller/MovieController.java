package com.rentfilms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentfilms.dao.MovieDao;
import com.rentfilms.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieDao movieDao;
	
	@RequestMapping(value = "/create")
	public void createMovie() {
		Movie m = new Movie();
		m.setNameMovie("asdasd");
		m.setDuration(60);
		movieDao.save(m);

	}
}
