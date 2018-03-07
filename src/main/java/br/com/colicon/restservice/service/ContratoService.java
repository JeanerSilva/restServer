package br.com.colicon.restservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.colicon.restservice.dao.IContratoDAO;
import br.com.colicon.restservice.entity.Contrato;

@Service
public class ContratoService implements IContratoService {
	@Autowired
	private IContratoDAO contratoDAO;
	@Override
	public Contrato getContratoById(int contratoId) {
		Contrato obj = contratoDAO.getContratoById(contratoId);
		return obj;
	}
	
	@Override
	public List<Contrato> getAllContratos(){
		return contratoDAO.getAllContratos();
	}
	
	@Override
	public synchronized boolean addContrato(Contrato contrato){
       if (contratoDAO.contratoExists(contrato.getContratoId())) {
    	   return false;
       } else {
    	   contratoDAO.addContrato(contrato);
    	   return true;
       }
	}
	
	@Override
	public void updateContrato(Contrato contrato) {
		contratoDAO.updateContrato(contrato);
	}
	
	@Override
	public void deleteContrato(int contratoId) {
		contratoDAO.deleteContrato(contratoId);
	}
	
	@Override
	public List<Contrato> getContratosByNumeroEAno(int numero, int ano) {
		return contratoDAO.getContratosByNumeroEAno(numero, ano);		
	}
	
	@Override
	public List<Contrato> getContratoByObjeto(String objeto) {
		return contratoDAO.getContratosByObjeto(objeto);
	}
	
	@Override
	public List<Contrato> getContratoByContratada(String contratada) {
		return contratoDAO.getContratosByContratada(contratada);
	}

	@Override
	public Contrato getContratoByNumeroEAno(int numero, int ano) {
		return contratoDAO.getContratoByNumeroEAno (numero, ano);
	} 
}
