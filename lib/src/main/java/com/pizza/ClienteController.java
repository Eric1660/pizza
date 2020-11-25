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

import com.pizzaria.model.Cliente;
import com.pizzaria.model.ClienteService;


@Controller
public class ClienteController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/cliente")
	public String cadastrar(Model model) {
		model.addAttribute("cliente",new Cliente());
		return "cadastrarCliente";
	}
	
	@PostMapping("/cliente")
	public String acao(@ModelAttribute Cliente clie,Model model) {
		model.addAttribute("cliente",clie);
		ClienteService pdao = context.getBean(ClienteService.class);
		pdao.insert(clie);
		return "clientesucesso";
		
	}
		
		
		@GetMapping("descr/{id}")
	    public String read(@PathVariable("id") int id, Model model){
			ClienteService pdao = context.getBean(ClienteService.class);
			Map<String,Object> cliente = pdao.getCliente(id);
			Cliente clie = new Cliente((String)cliente.get("nome"),(String)cliente.get("email"),(String)cliente.get("endereco"));
			model.addAttribute("cliente",clie);
			return "clientesucesso";
	    }
		
		@GetMapping("/produtos")
		public String listar(Model model) {
			ClienteService pdao = context.getBean(ClienteService.class);
			List<Map<String,Object>> cliente = pdao.getCliente();
			model.addAttribute("clie",cliente);
			return "clientelista";
		}
		
		@PostMapping("/apagar/{id}")
		public String deletar(@PathVariable("id") int id,Model model) {
			ClienteService pdao = context.getBean(ClienteService.class);
			pdao.deleteCliente(id);
			return "redirect:/cliente";
		}

}
