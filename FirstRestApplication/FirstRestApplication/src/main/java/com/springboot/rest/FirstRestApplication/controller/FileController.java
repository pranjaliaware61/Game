package com.springboot.rest.FirstRestApplication.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.FirstRestApplication.service.FileService;

@RestController
public class FileController {

	@Autowired
	FileService fileService;

	@GetMapping("/fetch/{number}")
	public void fetchModifiedFiles(@PathVariable int number) throws IOException {
		System.out.println("number:" + number);
		fileService.fetchModifiedFilesDesc(number);

	}

}
