package com.pizzaria.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PedidoService {
	  @Autowired 
	  PedidoDao pdao;
	  
	  public void insert(Pedido ped) {
	    pdao.insert(ped);
	  }
	  
	  public Map<String, Object> getPedido(int id) {
		  return pdao.getPedido(id);
	  }
	  
	  public List<Map<String, Object>>getPedido() {
	      return pdao.getPedido();
	  }
	  
	  public void deletePedido(int id) {
		  pdao.deletePedido(id);
	  }
	  
	  public void updatePedido(int id, Pedido ped) {
		  pdao.updatePedido(id, ped);
	  }
}


