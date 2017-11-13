package br.com.colicon.client;

import java.net.URI;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.colicon.restservice.entity.Contrato;

public class RestClientUtil {
    
	public Contrato getContratoByIdDemo(Integer id) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/colicon/buscacontrato/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Contrato> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Contrato.class, id);
        Contrato contrato = responseEntity.getBody();
        return contrato;
    }
	
	
	public Contrato getContratoByNumeroEAno(Integer numero, Integer ano) {
		System.out.println("Início");
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/colicon/buscacontrato/numero/{numero}/ano/{ano}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Contrato> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Contrato.class, numero, ano);
        Contrato contrato = responseEntity.getBody();
        return contrato;
    }
	
	public void getAllContratosDemo() {
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
    
    public void deleteContratoDemo(Integer id) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/colicon/deletacontrato/{id}";
        HttpEntity<Contrato> requestEntity = new HttpEntity<Contrato>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, id);        
    }
    
    public void deleteContratoPorNumeroEAno(Integer numero, Integer ano) {
    	RestClientUtil util = new RestClientUtil();
    	Integer id = util.getContratoByNumeroEAno(333, 100).getContratoId();
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
    	RestClientUtil util = new RestClientUtil();
    	//System.out.println("teste");
       // System.out.println("jeaner:" + util.getContratoByNumeroEAno(2, 2004));
        //util.getAllContratosDemo();
    	//System.out.println(util.addContratoDemo());
    	//util.updateContratoDemo();
    	//System.out.println(util.getContratoByIdDemo(2));
    	//Integer c = 2759;
    	//util.deleteContratoPorNumeroEAno(333, 100);
    	//System.out.println(util.getContratoByIdDemo(c));
    	util.deleteContratoDemo(57);
        
    }    
}
