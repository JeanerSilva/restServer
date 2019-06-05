package br.com.colicon.restservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class MyApplication { 
	

	@Autowired
	Properties properties;
	
	@Bean
	public UserDetails getUsers () { 
		System.out.println("Teste");
		UserDetails user = new UserDetails();
		user.setNome("nome");
		user.setEndereco("endereco");
		user.setRole(properties.getRoleSystem());
		return user;
	}     
	
	
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
    }     
	
	
	
}            