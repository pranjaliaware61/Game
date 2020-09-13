package com.springboot.rest.FirstRestApplication.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.rest.FirstRestApplication.model.Survey;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SurveyControllerIT {

	@LocalServerPort
	private int port;
	
	@Test
	void test() 
	{
		System.out.println("Port:"+port);
		//fail("Not yet implemented");
	}

}
