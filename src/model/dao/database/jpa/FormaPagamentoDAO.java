package model.dao.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import model.entity.FormaPagamento;

public class FormaPagamentoDAO extends GenericDAO<FormaPagamento> {

	public FormaPagamentoDAO(EntityManager manager) {
		super(manager);
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
	
	public List<FormaPagamento> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectFind() {
		// TODO Auto-generated method stub
		return null;
	}
}
