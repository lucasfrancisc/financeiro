package model.dao.database.jpa;

import javax.persistence.EntityManager;

import model.entity.CentroCusto;
import java.util.List;

public class CentroCustoDAO implements DAO {

	private final EntityManager manager;
	
	public CentroCustoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void create(CentroCusto t) {
		manager.persist(t);
	}

	@Override
	public CentroCusto read(Long id) {
		CentroCusto t = manager.find(CentroCusto.class, id);
		return t;
	}

	@Override
	public void update(CentroCusto t) {
		manager.merge(t);
	}

	@Override
	public void delete(Long id) {
		CentroCusto t = this.read(id);
		manager.remove(t);
	}
	
	@SuppressWarnings("unchecked")
	public List<CentroCusto> find(String pesquisa){		
		if (pesquisa == null) {
			pesquisa = "";
		}
		
		List<CentroCusto> dados = manager
				.createQuery("SELECT * From centroCusto Where descricao LIKE :pesquisa")
				.setParameter("pesquisa", "%" + pesquisa + "%")
				.getResultList();
		return dados;
	}

}
