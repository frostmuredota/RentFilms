package com.rentfilms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.rentfilms.model.Movie;
@Service
public interface MovieDao extends CrudRepository<Movie,Integer>{

}
