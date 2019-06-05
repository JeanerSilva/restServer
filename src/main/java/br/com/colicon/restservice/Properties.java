package br.com.colicon.restservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

	@Value("app.teste")
	private String teste;
	@Value("app.system")
	private String roleSystem;
	@Value("app.admin")
	private String roleAdmin;
	
	public String getTeste() {
		return teste;
	}
	
	public void setTeste(String teste) {
		this.teste = teste;
	}
	public String getRoleSystem() {
		return roleSystem;
	}
	public void setRoleSystem(String roleSystem) {
		this.roleSystem = roleSystem;
	}
	public String getRoleAdmin() {
		return roleAdmin;
	}
	public void setRoleAdmin(String roleAdmin) {
		this.roleAdmin = roleAdmin;
	}
	@Override
	public String toString() {
		return "Properties [teste=" + teste + ", roleSystem=" + roleSystem + ", roleAdmin=" + roleAdmin + "]";
	}
	
	
}
