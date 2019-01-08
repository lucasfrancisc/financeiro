package model.dao.database.jpa;

import javax.persistence.EntityManager;

import model.entity.Titulo;

public class TituloDAO extends GenericDAO<Titulo> {

	public TituloDAO(EntityManager manager) {
		super(manager);
	}	
		
	protected String getSelectFind() {
		return "SELECT t FROM Titulo AS t WHERE UPPER(t.descricao) LIKE :pesquisa";
	}
	
	public void teste() {
		
	}
}