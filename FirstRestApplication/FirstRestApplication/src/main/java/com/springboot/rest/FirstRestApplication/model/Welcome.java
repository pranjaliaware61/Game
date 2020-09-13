package com.springboot.rest.FirstRestApplication.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Welcome {

	@Value("${welcome.message}")
	String Message;

	public String WelcomeFetch() {
		// return "Welcome Folks Updated!!!!";
		return Message;
	}

}
