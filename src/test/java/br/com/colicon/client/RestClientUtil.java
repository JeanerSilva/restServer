package br.com.colicon.client;

import java.net.URI;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.validator.internal.constraintvalidators.bv.number.sign.PositiveOrZeroValidatorForNumber;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.colicon.restservice.entity.Contrato;

public class RestClientUtil {
    
	public static Contrato getContratoByIdDemo(Integer id) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/colicon/buscacontrato/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Contrato> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Contrato.class, id);
        Contrato contrato = responseEntity.getBody();
        return contrato;
    }
	
	
	public static Contrato getContratoByNumeroEAno(Integer numero, Integer ano) {
		System.out.println("Início");
    	HttpHeaders headers = new HttpHeaders();
    	headers.set("Jeaner","ocara");
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/colicon/buscacontrato/numero/{numero}/ano/{ano}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Contrato> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Contrato.class, numero, ano);
        Contrato contrato = responseEntity.getBody();
        return contrato;
    }
	
	public static void getAllContratosDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/colicon/buscatodoscontratos";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Contrato[]> responseEntity = restTemplate.exchange(
        		url, HttpMethod.GET, requestEntity, Contrato[].class);
        Contrato[] contratos = responseEntity.getBody();
        for(Contrato contrato : contratos) {
              System.out.println("Id:"+contrato.getContratoId()+", Numero:"+contrato.getNumero()
                      +", Ano: "+contrato.getAno());
        }
    }
    public String addContratoDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/colicon/adicionacontrato";
	    Contrato objContrato = new Contrato();
	    objContrato.setNumero(200);
	    objContrato.setAno(2001);
        
	    HttpEntity<Contrato> requestEntity = new HttpEntity<Contrato>(objContrato, headers);
        System.out.println("Request: ------------ " + requestEntity);
        URI uri = restTemplate.postForLocation(url, requestEntity);
       return uri.getPath();    	
    }
    public void updateContratoDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/colicon/atualizacontrato";
	    Contrato objContrato = new Contrato();
	    objContrato.setContratoId(2);
	    objContrato.setNumero(666);
	    objContrato.setAno(666);
	    objContrato.setAta("666");
        HttpEntity<Contrato> requestEntity = new HttpEntity<Contrato>(objContrato, headers);
        restTemplate.put(url, requestEntity);
    }
    
    public static void deleteContratoDemo(Integer id) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/colicon/deletacontrato/{id}";
        HttpEntity<Contrato> requestEntity = new HttpEntity<Contrato>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, id);        
    }
    
    public void deleteContratoPorNumeroEAno(Integer numero, Integer ano) {
    	Integer id = getContratoByNumeroEAno(333, 100).getContratoId();
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/colicon/buscacontrato/{id}";
        HttpEntity<Contrato> requestEntity = new HttpEntity<Contrato>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, id);        
    }

    
    
	@PersistenceContext
	static EntityManager entityManager;
	
    public static void main(String args[]) {
    	//System.out.println("teste");
        // System.out.println("jeaner:" + getContratoByNumeroEAno(2, 2004));
         //getAllContratosDemo();
    	//System.out.println(addContratoDemo());
    	//updateContratoDemo();
    	//System.out.println(getContratoByIdDemo(2));
    	Integer c = 2677;
    	//deleteContratoPorNumeroEAno(333, 100);
    	//System.out.println("Contrato:" + getContratoByIdDemo( c));
    	//deleteContratoDemo(57);
    	
    	System.out.println(getContratoByNumeroEAno(2,2004));
        
    }    
}
