package com.bolsadeideas.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsadeideas.springboot.form.app.controllers.entity.User;

@Controller
public class FormController {
	
	@RequestMapping(value="/formUser", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("title", "Form user");
		return "form";
	}
	

	
	/* If Entity object is the first parameter in the controller´s method, then 
	 * the form.html attributes will be mapped to the entitity´s fields
	 * (always when the form attributes are the same than User class)*/
	@RequestMapping(value="/sendInformation", method = RequestMethod.POST)
	public String process(User user, Model model) {
		model.addAttribute("title", "User information");
		model.addAttribute("user", user);
		return "infoUser";	
	}
	
	/* Verbose way of 'process' method
	@RequestMapping(value="/sendInformation", method = RequestMethod.POST)
	public String procesar(Model model,
			@RequestParam String userName,
			@RequestParam String email,
			@RequestParam String password) {
		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);
		model.addAttribute("title", "User information");
		model.addAttribute("user", user);
		return "infoUser";	
	}
	*/
}
