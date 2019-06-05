package br.com.colicon.restservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.colicon.restservice.Properties;
import br.com.colicon.restservice.UserDetails;
import br.com.colicon.restservice.UserService;

@Controller
@RequestMapping("colicon")
public class Segunda {
	
	@Autowired
	UserService userService;
	
	@Autowired
	Properties properties;
	
	private boolean acesso = false;
	
	@GetMapping("teste2") 
	@ResponseBody
	public String teste () {
		String texto = "";
		if (usuarioTemAcesso()) {  
			texto = "Acesso Liberado " + userService.toString() + "<br /><br /><br />" + "Properties: " + properties;
		} else {			
			texto = "Acesso negado";
		}
		return texto;
	}

	private boolean usuarioTemAcesso() {		
		List<String> items = Arrays.asList(properties.getRoleSystem().split("\\s*,\\s*"));
		items.forEach(new Consumer<String> () {
			@Override
			public void accept(String t) {
				System.out.println("\n" + properties.getRoleSystem());
				if (userService.getUserDetails().getRole().intern().equals(properties.getRoleSystem())) {
					setAcesso(true);
				};				
			}});		
		return isAcesso();
	}

	public boolean isAcesso() {
		return acesso;
	}

	public void setAcesso(boolean acesso) {
		this.acesso = acesso;
	}
	

}
