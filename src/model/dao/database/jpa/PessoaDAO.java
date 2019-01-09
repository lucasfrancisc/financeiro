package model.dao.database.jpa;

import javax.persistence.EntityManager;
import model.entity.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa> {

	public PessoaDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected String getSelectFind() {
		return "SELECT p FROM Pessoa AS p WHERE p.nome LIKE :pesquisa";
	}
}