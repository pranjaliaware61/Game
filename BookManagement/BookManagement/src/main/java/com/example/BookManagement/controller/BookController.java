package com.example.BookManagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.BookManagement.jpa.UserRepository;
import com.example.BookManagement.model.User;

@Controller
public class BookController 
{
	@Autowired
	UserRepository repository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(path="/welcome",method = RequestMethod.GET)
	public String welcomePage()
	{
		System.out.println("welcomePage");
		return "welcomeToBookManagement";
		
	}
	
	@RequestMapping(path="/signIn",method = RequestMethod.GET)
	public String showSignInPage(ModelMap model)
	{
		System.out.println("signInPage");
	//	model.addAttribute("user",new User((String)model.get("userName"), (String)model.get("password"), (String)model.get("email"), new Date(), (String)model.get("address"), (long)model.get("mobileNumber")));
		model.addAttribute("user",new User(" "," "," ", new Date()," "," "));
		
		return "Register";
		
	}
	
	
	@RequestMapping(path="/signIn",method=RequestMethod.POST)
	public String SignInPage(ModelMap model,@Valid @ModelAttribute("user") User user,BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println("Inside");
			return "Register";
		}
		System.out.println("UserName:"+user.getUserName());
		System.out.println("Password:"+user.getPassword());
		System.out.println("Email:"+user.getEmail());
		System.out.println("DOB:"+user.getDob());
		System.out.println("Address:"+user.getAddress());
		System.out.println("Mobile No. :"+user.getMobileNumber());
		repository.save(user);
		model.addAttribute("registered","User Registered");

		/*
		service.addUser((String) model.get("username"),todo.getDesc(),todo.getTargetDate(),false);
		return "redirect:/list-todos";*/
		
		return "welcomeToBookManagement";
		
	}

	

}
