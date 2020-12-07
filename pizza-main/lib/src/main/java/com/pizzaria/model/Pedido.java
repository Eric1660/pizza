package com.pizzaria.model;

public class Pedido {
	private int id;
	private String sabor;
	private String nome;
	
	public Pedido() {}
	
	public Pedido(String sabor, String nome) {
		this.sabor = sabor;
		this.nome = nome;
	}
	
	public Pedido(int id, String sabor, String nome) {
		this.id = id;
		this.sabor = sabor;
		this.nome = nome;
	}


	public int getId() {
		return id;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
