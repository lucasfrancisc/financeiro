package model.dao.database.jpa;

import javax.persistence.EntityManager;
import model.entity.Conta;

public class ContaDAO extends GenericDAO<Conta> {
	
	public ContaDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected String getSelectFind() {
		return "SELECT c FROM Conta AS c WHERE c.descricao LIKE :pesquisa";
	}
}