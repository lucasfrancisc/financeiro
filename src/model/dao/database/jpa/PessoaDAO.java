package model.dao.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import model.entity.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa> {

	private final EntityManager manager;
	
	public PessoaDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void create(Pessoa p) {
		manager.persist(p);
	}

	@Override
	public Pessoa read(Long id) {
		Pessoa p = manager.find(Pessoa.class, id);
		return p;
	}

	@Override
	public void update(Pessoa p) {
		manager.merge(p);
	}

	@Override
	public void delete(Long id) {
		Pessoa p = this.read(id);
		manager.remove(p);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> find(String pesquisa){		
		if (pesquisa == null) {
			pesquisa = "";
		}
		
		List<Pessoa> entitys = manager
				.createQuery("SELECT p FROM Pessoa AS p WHERE p.nome LIKE :pesquisa")
				.setParameter("pesquisa", "%" + pesquisa + "%")
				.getResultList();
		return entitys;
	}
}
