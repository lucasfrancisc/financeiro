package model.dao.database.jpa;

import javax.persistence.EntityManager;
import model.entity.FormaPagamento;

public class FormaPagamentoDAO extends GenericDAO<FormaPagamento> {

	public FormaPagamentoDAO(EntityManager manager) {
		super(manager);
	}
	
	@Override
	protected String getSelectFind() {
		return "SELECT f FROM FormaPagamento AS f WHERE f.descricao LIKE :pesquisa";
	}
}
