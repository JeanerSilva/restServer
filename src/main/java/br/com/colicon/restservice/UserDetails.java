package br.com.colicon.restservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDetails {

	private String nome;
	private String endereco;
	private String role;
	UserDetails userDetails;
	
	/*
	@PostConstruct
	public void getUsers (Properties properties) { 
		System.out.println("getUsers");
		this.nome = "nome";
		this.endereco = "endereco";
		this.role = properties.getRoleSystem();
		System.out.println("---post");
	}
	*/
	
	public UserDetails	(Properties properties) {
		System.out.println("getUsers");
		this.nome = "nome";
		this.endereco = "endereco";
		this.role = properties.getRoleSystem();
		System.out.println("---post");
	} 
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [nome=" + nome + ", endereco=" + endereco + ", role=" + role + "]";
	}
	
	
}
