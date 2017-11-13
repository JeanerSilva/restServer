package br.com.colicon.restservice.dao;
import java.util.List;

import br.com.colicon.restservice.entity.Contrato;
public interface IContratoDAO {
    List<Contrato> getAllContratos();
    Contrato getContratoById(int ContratoId);
    List<Contrato> getContratosByNumeroEAno (int numero, int ano);
    Contrato getContratoByNumeroEAno (int numero, int ano);
    void addContrato(Contrato Contrato);
    void updateContrato(Contrato Contrato);
    void deleteContrato(int ContratoId);
    boolean contratoExists(int id);
	List<Contrato> getContratosByObjeto(String objeto);
	List<Contrato> getContratosByContratada(String contratada);
}
 