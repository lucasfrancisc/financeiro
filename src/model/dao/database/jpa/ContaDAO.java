package model.dao.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import model.entity.Conta;

public class ContaDAO implements GenericInterfaceDAO<Conta> {
	
	private final EntityManager manager;
	
	public ContaDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void create(Conta e) {
		manager.persist(e);		
	}

	@Override
	public Conta read(Long id) {
		Conta e = manager.find(Conta.class, id);
		return e;
	}

	@Override
	public void update(Conta e) {
		manager.merge(e);		
	}

	@Override
	public void delete(Long id) {
		Conta e = this.read(id);
		manager.remove(e);
	}
	
	@SuppressWarnings("unchecked")	
	public List<Conta> find(String texto){
		if (texto == null) {
			texto = "";
		}
		List<Conta> entitys = manager
				.createQuery("SELECT c FROM Conta AS c WHERE c.descricao LIKE :texto")
				.setParameter("texto", "%" + texto + "%")
				.getResultList();
		return entitys;
	}
}
