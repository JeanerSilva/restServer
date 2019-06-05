package br.com.colicon.restservice;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	UserDetails userDetails = new UserDetails();
	
	public UserService	(Properties properties) {
		UserDetails userDetails = new UserDetails();
		Calendar c = Calendar.getInstance();
		userDetails.setNome(c.toString());
		userDetails.setEndereco("endereco");
		userDetails.setRole(properties.getRoleAdmin());
		this.userDetails = userDetails;
	} 
	
	
	public UserDetails getUserDetails () {
		return this.userDetails;
	}


	@Override
	public String toString() {
		return "UserService [userDetails=" + userDetails + "]";
	}

	
	
}
