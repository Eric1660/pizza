package com.pizzaria.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PizzaService {
	  @Autowired 
	  PizzaDao pdao;
	  
	  public void insert(Pizza piz) {
	    pdao.insert(piz);
	  }
	  
	  public Map<String, Object> getPizza(int id) {
		  return pdao.getPizza(id);
	  }
	  
	  public List<Map<String, Object>>getPizza() {
	      return pdao.getPizza();
	  }
	  
	  public void deletePizza(int id) {
		  pdao.deletePizza(id);
	  }
	  
	  public void updatePizza(int id, Pizza piz) {
		  pdao.updatePizza(id, piz);
	  }
}

