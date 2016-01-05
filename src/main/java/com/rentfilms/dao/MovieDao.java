package com.rentfilms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.rentfilms.model.Movie;
@Service
public interface MovieDao extends JpaRepository<Movie,Integer>{
	   @Query(value = "SELECT * FROM movie",nativeQuery=true)
		public List<Movie>allMyMovies();
	    @Query(value = "SELECT * FROM movie WHERE namemovie=?1",nativeQuery=true)
	    public Movie findByName(String nameMovie);
	
}
