package br.com.colicon.restservice.controller;

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
	
	
	//@Autowired
	UserDetails userDetails;
	
	@Autowired
	UserService userService;
	
	@Autowired
	Properties properties;
	
	@GetMapping("teste2") 
	@ResponseBody
	public String teste () {
		String texto = userService.toString() + "<br /><br /><br />" + "Properties: " + properties;
		System.out.println("User na segunda: " + texto);
		return texto;
	}
	

}
