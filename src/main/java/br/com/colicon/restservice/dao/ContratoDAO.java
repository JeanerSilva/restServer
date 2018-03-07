package br.com.colicon.restservice.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.colicon.restservice.entity.Contrato;
@Transactional
@Repository
public class ContratoDAO implements IContratoDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public Contrato getContratoById(int ContratoId) {
		Contrato retorno = entityManager.find(Contrato.class, ContratoId);
		return (null == retorno) ? null:retorno; 
	}
	
	@Override
	public List<Contrato> getAllContratos() {
		String hql = "FROM Contrato as contrato ORDER BY contrato.contratoId";
		List<Contrato> retorno = entityManager.createQuery(hql).getResultList(); 
		return (retorno.isEmpty()) ? null:retorno;
	}	
	
	@Override
	public void addContrato(Contrato Contrato) {
		entityManager.persist(Contrato);
	}
	
	@Override
	public void updateContrato(Contrato contratoatualizado) {
		Contrato contratonobanco = getContratoById(contratoatualizado.getContratoId());

		contratonobanco.setNumero (contratoatualizado.getNumero());
		contratonobanco.setAno (contratoatualizado.getAno());
		contratonobanco.setAta(contratoatualizado.getAta());
		contratonobanco.setNumero (contratoatualizado.getNumero());
		contratonobanco.setAno (contratoatualizado.getAno());
		contratonobanco.setAta (contratoatualizado.getAta());
		contratonobanco.setPasta (contratoatualizado.getPasta());
		contratonobanco.setModalidade (contratoatualizado.getModalidade());
		contratonobanco.setProcesso (contratoatualizado.getProcesso());
		contratonobanco.setProtocolo (contratoatualizado.getProtocolo());
		contratonobanco.setTipoobjeto (contratoatualizado.getTipoobjeto());
		contratonobanco.setObjeto (contratoatualizado.getObjeto());
		contratonobanco.setContratada (contratoatualizado.getContratada());				
		contratonobanco.setTerceirizados (contratoatualizado.getTerceirizados());
		contratonobanco.setRequisitante (contratoatualizado.getRequisitante());
		contratonobanco.setQuantidade (contratoatualizado.getQuantidade());
		contratonobanco.setVmensal (contratoatualizado.getVmensal());
		contratonobanco.setVtotal (contratoatualizado.getVtotal());
		contratonobanco.setFixo_estimado (contratoatualizado.getFixo_estimado());
		contratonobanco.setIniciovigencia (contratoatualizado.getIniciovigencia());	
		contratonobanco.setFimvigencia (contratoatualizado.getFimvigencia());
		contratonobanco.setContinuado (contratoatualizado.getContinuado());
		contratonobanco.setProrrogavel (contratoatualizado.getProrrogavel());
		contratonobanco.setGarantia (contratoatualizado.getGarantia());
		contratonobanco.setPortariafiscal (contratoatualizado.getPortariafiscal());
		contratonobanco.setFiscaltitular (contratoatualizado.getFiscaltitular());
		contratonobanco.setFiscalsubstituto (contratoatualizado.getFiscalsubstituto());
		contratonobanco.setObservacoes (contratoatualizado.getObservacoes());
		contratonobanco.setSituacao (contratoatualizado.getSituacao());
		contratonobanco.setEmpenho (contratoatualizado.getEmpenho());
		contratonobanco.setTermoaditivo (contratoatualizado.getTermoaditivo());
		contratonobanco.setMotivo (contratoatualizado.getMotivo());
		contratonobanco.setAumentomensal (contratoatualizado.getAumentomensal());
		entityManager.flush();
	}
	
	@Override
	public void deleteContrato(int ContratoId) {
		entityManager.remove(getContratoById(ContratoId));
	}
	
	@Override
	public boolean contratoExists(int id) {
		String hql = "FROM Contrato as c WHERE c.contratoId = :Pid";
		int count = entityManager.createQuery(hql)
		        .setParameter("Pid", id)
		        .getResultList().size();
		return count > 0 ? true : false;
	}
	
	@Override
	public List<Contrato> getContratosByNumeroEAno(int numero, int ano) {
		String hql = "FROM Contrato as c WHERE c.numero = :Pnumero and c.ano = :Pano";
		@SuppressWarnings("unchecked")
		List<Contrato> retorno = (List<Contrato>) entityManager.createQuery(hql)
				.setParameter("Pnumero", numero)
		        .setParameter("Pano", ano)
		        .getResultList();
		System.out.println(retorno);
		return (retorno.isEmpty()) ? null:retorno;
	}

	@Override
	public Contrato getContratoByNumeroEAno (int numero, int ano) {
		String hql = "SELECT DISTINCT c FROM Contrato c WHERE c.numero = :Pnumero and c.ano = :Pano";
		@SuppressWarnings("unchecked")
		List<Contrato> retorno = (List<Contrato>) entityManager.createQuery(hql)
				.setParameter("Pnumero", numero)
		        .setParameter("Pano", ano)
		        .getResultList();
		System.out.println(retorno);
		 return (retorno.isEmpty()) ? null:retorno.get(0);
	}
	
	@Override
	public List<Contrato> getContratosByObjeto (String objeto) {
		String hql = "FROM Contrato as c WHERE c.objeto LIKE :objetoP";
		@SuppressWarnings("unchecked")
		List<Contrato> retorno = (List<Contrato>) entityManager.createQuery(hql)
				.setParameter("objetoP", "%" + objeto + "%")
		        .getResultList();
		return (retorno.isEmpty()) ? null:retorno;
	}

	@Override
	public List<Contrato> getContratosByContratada(String contratada) {
		String hql = "FROM Contrato as c WHERE c.contratada LIKE :Pcontratada";
		@SuppressWarnings("unchecked")
		List<Contrato> retorno = (List<Contrato>) entityManager.createQuery(hql)
				.setParameter("Pcontratada", "%" + contratada + "%")
				.getResultList();
		return (retorno.isEmpty()) ? null:retorno;	
	}

}
