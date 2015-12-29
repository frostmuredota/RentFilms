package com.rentfilms;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.rentfilms.controller.ClientController;
import static org.hamcrest.Matchers.equalTo;

import com.rentfilms.dao.MovieDao;
import com.rentfilms.dao.ClientDao;
import com.rentfilms.model.Client;

import org.springframework.boot.test.SpringApplicationConfiguration;


@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = RentFilmsApplication.class)
@WebAppConfiguration
public class RentFilmsApplicationTests {
	
	@Mock
	private ClientDao dao;
	
	@Mock
	private MovieDao moviedao;
	
	@InjectMocks
	private ClientController rent;
	
	@Before
	public void setUp(){
		RestAssuredMockMvc.standaloneSetup(rent);
	}

	@Test
	public void contextLoads() {
		given().
        when().
            get("/rent/actor").
        then().
            assertThat().
            body("actorId",equalTo(0));

    }
	
	
	 @Test
	 public void testModelAndView(){
		 ModelAndView model = rent.showAllMyClients();
		 assertEquals("clients",model.getViewName());
		 
	 }
	 
}
