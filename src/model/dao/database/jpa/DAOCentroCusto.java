package model.dao.database.jpa;

import model.entity.CentroCusto;

public interface DAOCentroCusto {

	void create(CentroCusto p);
	
	CentroCusto read(Long id);
	
	void update(CentroCusto o);
	
	void delete(Long id);
}
