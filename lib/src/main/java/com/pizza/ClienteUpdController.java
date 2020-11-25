package com.pizza;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pizzaria.model.Cliente;
import com.pizzaria.model.ClienteService;


@Controller
public class ClienteUpdController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/upd1/{id}")
    public String updateForm(@PathVariable("id") int id, Model model){
		ClienteService pdao = context.getBean(ClienteService.class);
		Map<String,Object> antigo = pdao.getCliente(id);
		Cliente clie = new Cliente((String)antigo.get("nome"),(String)antigo.get("email"),(String)antigo.get("endereco"));
		model.addAttribute("antigo",clie);
		model.addAttribute("id",id);
		return "formclienteupd";
    }
	
	@PostMapping("/upd1/{id}")
	public String update(@PathVariable("id") int id,@ModelAttribute Cliente clie, Model model) {
		ClienteService pdao = context.getBean(ClienteService.class);
		pdao.updateCliente(id, clie);
		return "redirect:/cliente";
	}
}