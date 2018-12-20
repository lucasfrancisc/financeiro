package model.dao.database.jpa;

import model.entity.FormaPagamento;

public interface DAOFP {

	void create(FormaPagamento fp);
	
	FormaPagamento read(Long id);
	
	void update(FormaPagamento fp);
	
	void delete(Long id);
}
