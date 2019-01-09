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
	private EntityManager manager;
	
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
	 
	 public void inclui() {
		  T entity = null;
		  try {
		   entity = clazz.newInstance();
		  } catch(Exception e) {
		   throw new RuntimeException(e);
		  }
		  
		  entity.setOperacao(Operacao.INCLUSAO);
		  result.include("entity", entity);
		 }
		}
	 
	/*
	public void exibi(Long id){
		this.carregadados(id, Operacao.EXIBICAO);
		}
	
	public void altera(Long id){
		this.carregadados(id, Operacao.ALTERACAO);
		}		
	
	private void carregadados(Long id, Operacao operacao) {
		T obj = manager.find(clazz, id);
		manager.setOperacao(operacao);
		return obj;
	}
*/	

/*
	public void inclui() {
		Titulo entity = new Titulo();
		entity.setOperacao(Operacao.INCLUSAO);
		result.include("entity", entity);
	}
	
 * 
 */
