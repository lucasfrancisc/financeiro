package model.dao.database.jpa;

import model.entity.Base;

public interface GenericInterfaceDAO <T extends Base> {

	void create(T c);
	
	T read(Long id);
	
	void update(T c);
	
	void delete(Long id);	
}