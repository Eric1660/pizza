package com.pizza;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String principal(Model model) {
		String nome = "Projeto de Servidor 1";
		model.addAttribute("nome",nome);
		return "index";
	}
	
}