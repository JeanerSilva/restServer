package br.com.colicon.restservice;

public class UserDetails {

	private String nome;
	private String endereco;
	private String role;
	
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
