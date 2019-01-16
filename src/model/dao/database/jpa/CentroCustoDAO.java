package model.dao.database.jpa;

import javax.persistence.EntityManager;
import model.entity.CentroCusto;

public class CentroCustoDAO extends GenericDAO<CentroCusto> {

	public CentroCustoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected String getSelectFind() {
		return "SELECT c From CentroCusto AS c Where c.descricao LIKE :pesquisa";
	}

}
