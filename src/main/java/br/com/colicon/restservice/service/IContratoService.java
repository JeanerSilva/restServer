package br.com.colicon.restservice.service;

import java.util.List;

import br.com.colicon.restservice.entity.Contrato;

public interface IContratoService {
     List<Contrato> getAllContratos();
     Contrato getContratoById(int ContratoId);
     List<Contrato> getContratosByNumeroEAno(int numero, int ano);
     Contrato getContratoByNumeroEAno (int numero, int ano);
     List<Contrato> getContratoByObjeto(String objeto);
     List<Contrato> getContratoByContratada(String contratada);
     boolean addContrato(Contrato Contrato);
     void updateContrato(Contrato Contrato);
     void deleteContrato(int ContratoId);
}
