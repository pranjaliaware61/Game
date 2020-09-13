package com.springboot.rest.FirstRestApplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.FirstRestApplication.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	Employee employeeObj;

	@GetMapping("/employeeDetails")
	public Map<String, String> details() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", employeeObj.getId());
		map.put("name", employeeObj.getName());
		map.put("organisation", employeeObj.getOrganisation());
		return map;

	}

}
