package com.springboot.rest.FirstRestApplication.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("employee")
public class Employee {

	// @Value("${employee.id}")
	private String id;

	// @Value("${employee.name}")
	private String name;

	// @Value("${employee.organisation}")
	private String organisation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public void Employee() {
		System.out.println("Default Employee Constructor");
	}

}
