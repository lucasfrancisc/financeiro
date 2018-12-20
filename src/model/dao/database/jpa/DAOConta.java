package model.dao.database.jpa;

import model.entity.Conta;

public interface DAOConta{
	
	void create(Conta c);
	
	Conta read(Long id);
	
	void update(Conta c);
	
	void delete(Long id);
	
}