package model.dao.database.jpa;

import javax.persistence.EntityManager;

import model.entity.FormaPagamento;

public class FormaPagamentoDAO extends GenericDAO<FormaPagamento> {

	public FormaPagamentoDAO(EntityManager manager) {
		super(manager);
	}	
		
	protected String getSelectFind() {
		return "SELECT fp FROM FormaPagamento AS fp WHERE UPPER(fp.descricao) LIKE :pesquisa";
	}
	
	public void teste() {
		
	}
}