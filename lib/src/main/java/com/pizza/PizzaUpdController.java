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

import com.pizzaria.model.Pizza;
import com.pizzaria.model.PizzaService;


@Controller
public class PizzaUpdController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/upd/{id}")
    public String updateForm(@PathVariable("id") int id, Model model){
		PizzaService pdao = context.getBean(PizzaService.class);
		Map<String,Object> antigo = pdao.getPizza(id);
		Pizza piz = new Pizza((String)antigo.get("sabor"),(Double)antigo.get("preco"),(String)antigo.get("descricao"));
		model.addAttribute("antigo",piz);
		model.addAttribute("id",id);
		return "formpizzaupd";
    }
	
	@PostMapping("/upd/{id}")
	public String update(@PathVariable("id") int id,@ModelAttribute Pizza piz, Model model) {
		PizzaService pdao = context.getBean(PizzaService.class);
		pdao.updatePizza(id, piz);
		return "redirect:/pizza";
	}
}