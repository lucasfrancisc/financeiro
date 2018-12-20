package model.dao.database.jpa;

import model.entity.Pessoa;

public interface DAOpessoa {

	void create(Pessoa p);
	
	Pessoa read(Long id);
	
	void update(Pessoa p);
	
	void delete(Long id);

	
}