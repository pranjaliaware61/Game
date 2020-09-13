package com.springboot.rest.FirstRestApplication.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.rest.FirstRestApplication.model.Question;
import com.springboot.rest.FirstRestApplication.service.SurveyService;

@RestController
public class SurveyController {
	@Autowired
	SurveyService service;

	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveSurveyQuestions(@PathVariable String surveyId) {
		System.out.println("Inside retrieveSurveys");
		List<Question> questionsReturned = service.retrieveQuestions(surveyId);
		return questionsReturned;
	}

	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<Object> addQuestion(@PathVariable String surveyId, @RequestBody Question question) {
		System.out.println("Inside addQuestion");
		Question q = service.addQuestion(surveyId, question);

		if (q == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(q.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveQuestionForSurvey(@PathVariable String surveyId, @PathVariable String questionId) {
		System.out.println("Inside retrieveQuestionForSurvey");
		Question question = service.retrieveQuestion(surveyId, questionId);
		return question;
	}

}
