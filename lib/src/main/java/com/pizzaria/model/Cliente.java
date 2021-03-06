package com.pizzaria.model;

public class Cliente {
	private int id;
	private String nome;
	private String email;
	private String endereco;
	
	public Cliente() {}
	
	public Cliente(String nome, String email, String endereco) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}
	
	public Cliente(int id, String nome, String email, String endereco) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	
		
	
}
