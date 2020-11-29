package com.bolsadeideas.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {
	
	@RequestMapping(name="/form", method = RequestMethod.GET)
	public String form() {
		return "formulario";
	}
	
	@RequestMapping(name="/envio", method = RequestMethod.POST)
	public void envioDatos(Model model) {
		
	}
	
}
