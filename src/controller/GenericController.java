package controller;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.FabricaEntityManagerFactory;
import model.dao.database.jpa.GenericDAO;
import model.dao.database.jpa.TituloDAO;
import model.entity.Base;
import util.enumeration.Operacao;

public class GenericController <T extends Base, D extends GenericDAO<T>> {

	private final Class<T> clazz;
	private final Class<D> clazzDAO;
	protected D dao;
	protected final Result result;
	private final EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public GenericController(Result result) {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.clazzDAO = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];		
		this.result = result;
		this.manager = FabricaEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		try {
			dao = clazzDAO.getDeclaredConstructor(EntityManager.class).newInstance(manager);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void add() {
		T entity = null;
		try {
			entity = clazz.newInstance();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		entity.setOperacao(Operacao.INCLUSAO);
		result.include("entity", entity);
	}
	
 	public void save() {
	  try {
		  T entity = null;
		  try {
		      entity = clazz.newInstance();
		      entity.setOperacao(Operacao.INCLUSAO);
		  } catch(Exception e) {
			  throw new RuntimeException(e);
		  }
		
		  this.manager.getTransaction().begin();
		
		  if (entity.getOperacao().equals(Operacao.INCLUSAO)) {
			  dao.create(entity);
			  System.out.println("Título incluido com sucesso!");
		  } else if (entity.getOperacao().equals(Operacao.ALTERACAO)){
			  dao.update(entity);
		  	  System.out.println("Título alterado com sucesso!");
		  }
	  	  this.manager.getTransaction().commit();
	  } catch(Exception e) {
		  this.manager.getTransaction().rollback();
	  }
    }

}
