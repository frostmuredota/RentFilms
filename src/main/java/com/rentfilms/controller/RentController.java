package com.rentfilms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RentController {
	@RequestMapping(value = {"/","/index"})
	public ModelAndView index() {
		ModelAndView index = new ModelAndView();
		index.setViewName("index");
		return index;
	}

	@RequestMapping(value = "/saludar")
	public String holaMundo() {
		return "hola mundo";
	}
}
