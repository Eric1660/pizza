package com.pizza;

import java.util.List;
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
public class PizzaController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/pizza")
	public String cadastrar(Model model) {
		model.addAttribute("pizza",new Pizza());
		return "cadastrarPizza";
	}
	
	@PostMapping("/pizza")
	public String acao(@ModelAttribute Pizza piz,Model model) {
		model.addAttribute("pizza",piz);
		PizzaService pdao = context.getBean(PizzaService.class);
		pdao.insert(piz);
		return "pizzasucesso";
		
	}
		
		
	@GetMapping("descr/{id}")
	    public String read(@PathVariable("id") int id, Model model){
			PizzaService pdao = context.getBean(PizzaService.class);
			Map<String,Object> pizza = pdao.getPizza(id);
			Pizza piz = new Pizza((String)pizza.get("sabor"),(Double)pizza.get("preco"),(String)pizza.get("descricao"));
			model.addAttribute("pizza",piz);
			return "pizzasucesso";
	    }
		
		@GetMapping("/pizza")
		public String listar(Model model) {
			PizzaService pdao = context.getBean(PizzaService.class);
			List<Map<String,Object>> pizza = pdao.getPizza();
			model.addAttribute("piz",pizza);
			return "pizzalista";
		}
		
		@PostMapping("/apagar/{id}")
		public String deletar(@PathVariable("id") int id,Model model) {
			PizzaService pdao = context.getBean(PizzaService.class);
			pdao.deletePizza(id);
			return "redirect:/pizza";
		}

}
