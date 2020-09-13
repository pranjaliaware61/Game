package com.springboot.rest.FirstRestApplication.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.springboot.rest.FirstRestApplication.model.Question;
import com.springboot.rest.FirstRestApplication.model.Survey;

@Component
public class SurveyService {
	private static List<Survey> surveys = new ArrayList<Survey>();

	static {
		System.out.println("Inside static block");
		Question question1 = new Question("Question1", "Largest country in the world", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));
		Question question2 = new Question("Question2", "Most Populus Country in the World", "China",
				Arrays.asList("India", "Russia", "United States", "China"));
		Question question3 = new Question("Question3", "Highest GDP in the World", "United States",
				Arrays.asList("India", "Russia", "United States", "China"));
		Question question4 = new Question("Question4", "Second largest english speaking country", "India",
				Arrays.asList("India", "Russia", "United States", "China"));
		List<Question> q = new ArrayList<Question>();
		q.add(question1);
		q.add(question2);
		q.add(question3);
		q.add(question4);

		Survey sobj = new Survey("Survey1", "My Favorite Survey", "Description of the Survey", q);

		surveys.add(sobj);
	}

	@Profile("prod")
	@Bean
	public String dummy() {
		return "dummy";

	}

	public SurveyService() {
		System.out.println("Default SurveyService Constructor");
	}

	public List<Survey> retrieveAllSurveys() {
		return surveys;
	}

	public Survey retrieveSurvey(String surveyid) {
		for (Survey temp : surveys) {
			if (temp.getId() == surveyid) {
				return temp;
			}
		}

		return null;
	}

	public List<Question> retrieveQuestions(String surveyid) {
		if (surveys == null) {
			return null;
		}
		for (Survey temp : surveys) {
			if (temp.getId().equals(surveyid)) {
				return temp.getQuestions();
			}
		}
		return null;
	}

	public Question retrieveQuestion(String surveyid, String questionid) {
		if (surveys == null) {
			return null;
		}
		List<Question> fetch = retrieveQuestions(surveyid);

		for (Question temp : fetch) {
			if (temp.getId().equals(questionid)) {
				System.out.println("Condition satisfied");
				return temp;
			}
		}

		return null;

	}

	public Question addQuestion(String surveyid, Question question) {

		if (surveys == null) {
			return null;
		}

		for (Survey temp : surveys) {
			if (temp.getId().equals(surveyid)) {
				System.out.println("Condition Satisfied");
				SecureRandom random = new SecureRandom();
				String randomId = new BigInteger(130, random).toString(32);
				System.out.println("randomId:" + randomId);
				question.setId(randomId);
				/*
				 * Question question5 = new Question(randomId, "First largest english speaking
				 * country", "United States", Arrays.asList("India", "Russia", "United States",
				 * "China")); temp.setQuestions(Arrays.asList(question5));
				 */
				temp.getQuestions().add(question);
				return question;
			}

		}
		return null;

	}

}
