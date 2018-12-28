package model.dao.database.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import model.entity.Base;

public abstract class GenericDAO <T extends Base> implements GenericInterfaceDAO<T> {
	
	protected EntityManager manager;
	private Class<T> clazz; 
	
	protected abstract String getSelectFind();		
	
	@SuppressWarnings("unchecked")
	public GenericDAO(EntityManager manager) {			
		this.manager = manager;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];		
	}
		
	@Override
	public void create(T c) {
		manager.persist(c);
	}

	@Override
	public T read(Long id) {
		T obj = manager.find(clazz, id);
		return obj;
	}

	@Override
	public void update(T c) {
		manager.merge(c);		
	}

	@Override
	public void delete(Long id) {
		T obj = this.read(id);
		manager.remove(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String pesquisa) {
		if (pesquisa == null) {
			pesquisa = "";
		}
		
		List<T> entitys = manager
				.createQuery(this.getSelectFind())
				.setParameter("pesquisa", "%" + pesquisa + "%")
				.getResultList();
		return entitys;
	}	
}
