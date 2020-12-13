package com.bolsadeideas.springboot.form.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	 * (always when the form attributes are the same name than User class)*/
	@RequestMapping(value="/sendInformation", method = RequestMethod.POST)
	public String process(@Valid User user, BindingResult bindingResult, Model model) {
		// the BindingResult object, is useful to validate if entity object has all their attributes well formed or has an error in any field 
		if(bindingResult.hasErrors()) {
			Map<String, String> errors = new HashMap<String,String>();
			bindingResult.getFieldErrors().forEach(err -> {
				errors.put(err.getField(), "El campo".concat(err.getField().concat(" , tiene errores")));
			});
			model.addAttribute("errors", errors);
			return "form";
		}
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
