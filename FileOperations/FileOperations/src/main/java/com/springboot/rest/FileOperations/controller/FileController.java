package com.springboot.rest.FileOperations.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.FileOperations.service.FileService;

@RestController
public class FileController {

	@Autowired
	FileService fileService;

	@GetMapping("/fetch/lastModified/{number}")
	public String fetchModifiedFiles(@PathVariable int number) throws IOException {
		// System.out.println("number:" + number);
		String message = fileService.fetchModifiedFilesDesc(number);
		return message;

	}

}
