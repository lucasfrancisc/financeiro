package model.dao.jpa;

import javax.persistence.EntityManager;

import model.entity.FormaPagamento;

public class FormaPagamentoDAO implements DAOFP {

	private final EntityManager manager;
	
	public FormaPagamentoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void create(FormaPagamento f) {
		manager.persist(f);
	}

	@Override
	public FormaPagamento read(Long id) {
		FormaPagamento f = manager.find(FormaPagamento.class, id);
		return f;
	}

	@Override
	public void update(FormaPagamento f) {
		manager.merge(f);
	}

	@Override
	public void delete(Long id) {
		FormaPagamento f = this.read(id);
		manager.remove(f);
	}
}
