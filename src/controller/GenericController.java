package controller;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.FabricaEntityManagerFactory;
import model.dao.database.jpa.GenericDAO;
import model.entity.Base;
import util.enumeration.Operacao;

public class GenericController <T extends Base, D extends GenericDAO<T>> {

	private final Class<T> clazz;
	private final Class<D> clazzDAO;
	protected D dao;
	protected final Result result;
	protected final EntityManager manager;
	
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
	
	protected void save(T entity, Operacao op) {
		try {
			this.manager.getTransaction().begin();

			if (Operacao.INCLUSAO.equals(op)) {
				dao.create(entity);
				System.out.println("Registro incluido com sucesso!");
			} else if (Operacao.ALTERACAO.equals(op)) {
				dao.update(entity);
				System.out.println("Registro alterado com sucesso!");
			}
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			this.manager.getTransaction().rollback();
		}
		
		result.redirectTo(this).listagem("");
	}
	
	public void listagem(String pesquisa) {
		throw new UnsupportedOperationException("Método deve ser sobreescrito pela controller filha!");
	}
}
