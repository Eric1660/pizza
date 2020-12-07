package com.pizza;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/")
	public String principal(Model model) {
		String nome = "Projeto de Servidor 1";
		model.addAttribute("nome",nome);
		return "principal";
	}
	
}
