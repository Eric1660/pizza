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

import com.pizzaria.model.Pedido;
import com.pizzaria.model.PedidoService;

@Controller
public class PedidoController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/pedido")
	public String cadastrar(Model model) {
		model.addAttribute("pedido",new Pedido());
		return "cadastrarPedido";
	}
	
	@PostMapping("/pedido")
	public String acao(@ModelAttribute Pedido ped,Model model) {
		model.addAttribute("pedido",ped);
		PedidoService pdao = context.getBean(PedidoService.class);
		pdao.insert(ped);
		return "pedidosucesso";
		
	}
		
		
	@GetMapping("descr/{id}")
	    public String read(@PathVariable("id") int id, Model model){
			PedidoService pdao = context.getBean(PedidoService.class);
			Map<String,Object> pedido = pdao.getPedido(id);
			Pedido ped = new Pedido((String)pedido.get("nome"),(String)pedido.get("sabor"));
			model.addAttribute("pedido",ped);
			return "pedidosucesso";
	    }
		
		@GetMapping("/pedido")
		public String listar(Model model) {
			PedidoService pdao = context.getBean(PedidoService.class);
			List<Map<String,Object>> pedido = pdao.getPedido();
			model.addAttribute("ped",pedido);
			return "pedidolista";
		}
		
		@PostMapping("/apagar/{id}")
		public String deletar(@PathVariable("id") int id,Model model) {
			PedidoService pdao = context.getBean(PedidoService.class);
			pdao.deletePedido(id);
			return "redirect:/pedido";
		}

}
