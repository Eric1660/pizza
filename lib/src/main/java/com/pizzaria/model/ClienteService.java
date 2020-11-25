package com.pizzaria.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClienteService {
	  @Autowired 
	  ClienteDao pdao;
	  
	  public void insert(Cliente clie) {
	    pdao.insert(clie);
	  }
	  
	  public Map<String, Object> getCliente(int id) {
		  return pdao.getCliente(id);
	  }
	  
	  public List<Map<String, Object>>getCliente() {
	      return pdao.getCliente();
	  }
	  
	  public void deleteCliente(int id) {
		  pdao.deleteCliente(id);
	  }
	  
	  public void updateCliente(int id, Cliente clie) {
		  pdao.updateCliente(id, clie);
	  }
}


