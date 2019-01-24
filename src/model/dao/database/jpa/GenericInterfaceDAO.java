 package model.dao.database.jpa;

import java.util.List;

import model.entity.Base;

public interface GenericInterfaceDAO <T extends Base> {

	void create(T c);
	
	T read(Long id);
	
	void update(T c);
	
	void delete(Long id);

	List<T> find(String pesquisa);	
}