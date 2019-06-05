package br.com.colicon.restservice.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.colicon.restservice.Properties;
import br.com.colicon.restservice.UserDetails;
import br.com.colicon.restservice.UserService;
import br.com.colicon.restservice.entity.Contrato;
import br.com.colicon.restservice.service.IContratoService;

@Controller
@RequestMapping("colicon")
public class ContratoController {
	@Autowired
	private IContratoService contratoService;
	
	@Autowired
	Properties properties;
	
	@Autowired
	UserService userService;

	@GetMapping("teste") 
	@ResponseBody
	public String teste () {	
		// UserService userService = new UserService(); // se usar o new ele cria uma instância a cada vez que o controller for chamado
		System.out.println("properties: " + properties);
		List<String> items = Arrays.asList(properties.getRoleAdmin().split("\\s*,\\s*"));
		items.forEach( i -> System.out.println(i));
		System.out.println("properties: " + properties.getRoleAdmin());
		String texto = userService.toString() + "<br /><br /><br />" + "Properties: " + properties+ "<br /><br /><br />";
		return texto;
	}
	
	@GetMapping("buscacontrato/{id}")
	public ResponseEntity<Contrato> getContratoById(@PathVariable("id") Integer id) {
		Contrato contrato = contratoService.getContratoById(id);
		return (null == contrato) ? new ResponseEntity<Contrato>(HttpStatus.EXPECTATION_FAILED): new ResponseEntity<Contrato>(contrato, HttpStatus.FOUND);
 
	}
	
	@GetMapping("buscacontratos/numero/{numero}/ano/{ano}")
	public ResponseEntity<List<Contrato>> getContratosByNumeroEAno(@PathVariable("numero") Integer numero, @PathVariable("ano") Integer ano) {
		List<Contrato> contratos = contratoService.getContratosByNumeroEAno (numero, ano);
		return (null == contratos) ? new ResponseEntity<List<Contrato>>(HttpStatus.EXPECTATION_FAILED): new ResponseEntity<List<Contrato>>(contratos, HttpStatus.FOUND);
	}
	
	///////////////////////////////////////////
	@PostMapping("buscacontrato/numero/{numero}/ano/{ano}")
	public ResponseEntity<Contrato> getContratoByNumeroEAno (
			@PathVariable("numero") Integer numero, 
			@PathVariable("ano") Integer ano,
			@RequestHeader(value="Jeaner", defaultValue="foo") String header) {
		Contrato contrato = contratoService.getContratoByNumeroEAno (numero, ano);
		System.out.println("============ " + header);
		
		return (null == contrato) ? new ResponseEntity<Contrato>(HttpStatus.EXPECTATION_FAILED): new ResponseEntity<Contrato>(contrato, HttpStatus.FOUND);
	}
	
	@PostMapping("teste")
	@ResponseBody
	public String teste (			
			@RequestHeader(value="Jeaner", defaultValue="foo") String header) {
		String message = "============ " + header;
		System.out.println(message);
		return message;
		//return (null == contrato) ? new ResponseEntity<Contrato>(HttpStatus.EXPECTATION_FAILED): new ResponseEntity<Contrato>(contrato, HttpStatus.FOUND);
	}

	

	
	@GetMapping("buscacontratoporobjeto/{objeto}")
	public ResponseEntity<List<Contrato>> getContratoByNumeroEAno(@PathVariable("objeto") String objeto) {
	List<Contrato> contratos = contratoService.getContratoByObjeto(objeto);
		return (null == contratos) ? new ResponseEntity<List<Contrato>>(HttpStatus.EXPECTATION_FAILED): new ResponseEntity<List<Contrato>>(contratos, HttpStatus.FOUND);
	}

	@GetMapping("buscacontratoporcontratada/{contratada}")
	public ResponseEntity<List<Contrato>> getContratoByContratada(@PathVariable("contratada") String contratada) {
		List<Contrato> contratos = contratoService.getContratoByContratada(contratada);
		return (null == contratos) ? new ResponseEntity<List<Contrato>>(HttpStatus.EXPECTATION_FAILED): new ResponseEntity<List<Contrato>>(contratos, HttpStatus.FOUND);
	}
	
	@GetMapping("buscatodoscontratos")
	public ResponseEntity<List<Contrato>> getAllContratos() {
		List<Contrato> contratos = contratoService.getAllContratos();
		return (null == contratos) ? new ResponseEntity<List<Contrato>>(HttpStatus.EXPECTATION_FAILED): new ResponseEntity<List<Contrato>>(contratos, HttpStatus.FOUND);
	}
	
	@PostMapping("adicionacontrato")
	public ResponseEntity<Void> addContrato(@RequestBody Contrato Contrato, UriComponentsBuilder builder) {
        boolean flag = contratoService.addContrato(Contrato);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/contrato/{id}").buildAndExpand(Contrato.getContratoId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("atualizacontrato")
	public ResponseEntity<Contrato> updateContrato(@RequestBody Contrato contrato) {
		contratoService.updateContrato(contrato);
		return (null == contrato) ? new ResponseEntity<Contrato>(HttpStatus.EXPECTATION_FAILED): new ResponseEntity<Contrato>(contrato, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("deletacontrato/{id}")
	public ResponseEntity<Void> deleteContrato(@PathVariable("id") Integer id) {
		contratoService.deleteContrato(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}	

} 