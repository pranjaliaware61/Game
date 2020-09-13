package com.springboot.rest.FirstRestApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.FirstRestApplication.model.Welcome;

@RestController
public class WelcomeController 
{
	@Autowired
	Welcome welcome;
	
	@RequestMapping("/welcome")
	public String WelcomeService()
	{
		return welcome.WelcomeFetch();
	}

}
