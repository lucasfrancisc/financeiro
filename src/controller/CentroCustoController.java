package controller;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jdbc.DatabaseUtil;
import model.dao.database.jpa.CentroCustoDAO;
import model.dao.database.jpa.FabricaEntityManagerFactory;
import model.entity.CentroCusto;
import util.enumeration.Operacao;

@SuppressWarnings("unused")
@Resource
public class CentroCustoController {
	
	private Result result;
	private DatabaseUtil databaseUtil;
	private final CentroCustoDAO dao;
	private final EntityManager manager;
	
	@SuppressWarnings("static-access")
	public CentroCustoController(Result result) {
		this.result = result;
		databaseUtil = databaseUtil.getInstanciaUnica();
		manager  = FabricaEntityManagerFactory.getUnicaInstancia().getEntityManagerFactory().createEntityManager();
		dao = new CentroCustoDAO(manager);
	}
	
	public void inclui() {
		CentroCusto entity = new CentroCusto();
		entity.setOperacao(Operacao.INCLUSAO);
		result.include("entity", entity);
	}
	
	public void grava(CentroCusto centroCusto) {
		try {
			manager.getTransaction().begin();
			
			if (centroCusto.getId() == null) {
				dao.create(centroCusto);
				System.out.println("Centro de Custo incluido com sucesso!");
			} else {
				dao.update(centroCusto);
				System.out.println("Centro de Custo alterado com sucesso!");
			}
			manager.getTransaction().commit();
		} catch(Exception e) {
			manager.getTransaction().rollback();
		}
		result.redirectTo(this).lista("");
	}
	
	public void exibi(Long id) {
		CentroCusto centroCusto = dao.read(id);
		result.include("centroCusto", centroCusto);
	}
	
	public void exclui(Long id) {
	  try {	
  	    manager.getTransaction().begin();
		dao.delete(id);
		manager.getTransaction().commit();
	  } catch(Exception e) {
		  manager.getTransaction().rollback();  
	  }
	  
	  result.redirectTo(this).lista("");
	}
	
	public void lista(String pesquisa) {
		List<CentroCusto> entitys = dao.find(pesquisa);
		result.include("entitys", entitys);
		result.include("pesquisa", pesquisa);
	}
	
}
