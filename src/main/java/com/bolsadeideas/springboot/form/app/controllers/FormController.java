package com.bolsadeideas.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	
	@RequestMapping(value="/formUser", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("title", "Form user");
		return "form";
	}
	
	@RequestMapping(value="/sendInformation", method = RequestMethod.POST)
	public String procesar(Model model,
			@RequestParam String userName,
			@RequestParam String email,
			@RequestParam String password) {
		model.addAttribute("title", "User information");
		model.addAttribute("userName", userName);
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		return "infoUser";
		
	}
	
}
