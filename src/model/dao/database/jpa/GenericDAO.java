package model.dao.database.jpa;

import model.entity.Base;

public class GenericDAO <T extends Base> implements GenericInterfaceDAO<T> {

	@Override
	public void create(T c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	
}
