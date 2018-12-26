package controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jdbc.DatabaseUtil;
import model.dao.database.jpa.FabricaEntityManagerFactory;
import model.dao.database.jpa.GenericDAO;
import model.entity.Base;
import model.entity.CentroCusto;
import model.entity.Titulo;
import util.FuncoesUtil;
import util.enumeration.Operacao;

@Resource
public class GenericController <T extends Base> {

	private Result result;
	private DatabaseUtil databaseUtil;
	private final GenericDAO<T> dao;
	private final EntityManager manager;
	
	public GenericController(Result result) {
		this.result = result;
		databaseUtil = databaseUtil.getInstanciaUnica();
		manager  = FabricaEntityManagerFactory.getUnicaInstancia().getEntityManagerFactory().createEntityManager();
		dao = new GenericDAO(T);
	}
	
	public void add() {
	}

	public void save(T t) {
	  try {
		FuncoesUtil.iniciaTransacao(manager);
			
	    if (t.getOperacao().equals(Operacao.INCLUSAO)) {
		  dao.create(t);
	      System.out.println("Registro incluido com sucesso!");
	    } else
		    if (t.getOperacao().equals(Operacao.ALTERACAO)){
			  dao.update(t);
			  System.out.println("Registro alterado com sucesso!");
		    }
	  	FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
		}
		
		result.redirectTo(this).listagem("");
	}
	
	public void exibir(Long id) {
		T t = dao.read(id);
		result.include("T", t);
	}

	public void excluir(Long id) {
	  try {	
	    manager.getTransaction().begin();
		dao.delete(id);
		manager.getTransaction().commit();
	  } catch(Exception e) {
		  manager.getTransaction().rollback();  
	  }
		  
	  result.redirectTo(this).listagem("");
    }
	
}
