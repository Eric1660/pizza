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

import com.pizzaria.model.Pedido;
import com.pizzaria.model.PedidoService;


@Controller
public class PedidoUpdController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/upd/{id}")
    public String updateForm(@PathVariable("id") int id, Model model){
		PedidoService pdao = context.getBean(PedidoService.class);
		Map<String,Object> antigo = pdao.getPedido(id);
		Pedido ped = new Pedido((String)antigo.get("nome"),(String)antigo.get("sabor"));
		model.addAttribute("antigo",ped);
		model.addAttribute("id",id);
		return "formpedidoupd";
    }
	
	@PostMapping("/upd/{id}")
	public String update(@PathVariable("id") int id,@ModelAttribute Pedido ped, Model model) {
		PedidoService pdao = context.getBean(PedidoService.class);
		pdao.updatePedido(id, ped);
		return "redirect:/pedido";
	}
}