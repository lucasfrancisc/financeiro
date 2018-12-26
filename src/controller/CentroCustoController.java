package controller;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jdbc.DatabaseUtil;
import model.dao.database.jpa.CentroCustoDAO;
import model.dao.database.jpa.FabricaEntityManagerFactory;
import model.dao.database.jpa.GenericDAO;
import controller.GenericController;
import model.entity.CentroCusto;

@Resource
public class CentroCustoController extends GenericController<CentroCusto> {
	
	public CentroCustoController(Result result) {
		super(result);
		// TODO Auto-generated constructor stub
	}

	private Result result;
	

	public void add() {
	}
	
	public void save(CentroCusto centroCusto) {
		try {
			manager.getTransaction().begin();
			
			if (centroCusto.getId() == null) {
				dao.create(centroCusto);
				System.out.println("Título incluido com sucesso!");
			} else {
				dao.update(centroCusto);
				System.out.println("Título alterado com sucesso!");
			}
			manager.getTransaction().commit();
		} catch(Exception e) {
			manager.getTransaction().rollback();
		}
		result.redirectTo(this).listagem("");
	}
	
	public void exibir(Long id) {
		CentroCusto centroCusto = dao.read(id);
		result.include("centroCusto", centroCusto);
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
	
	@SuppressWarnings("unchecked")
	public void listagem(String pesquisa) {
		if (pesquisa == null) {
			pesquisa = "";	
		}
		
		List<CentroCusto> centroCusto = manager.createQuery("Select t From CentroCusto as t where t.descricao like :pesquisa order by t.id")
				                               .setParameter("pesquisa", "%" + pesquisa + "%")
				                               .getResultList();
		result.include("centroCusto", centroCusto);
	}
	
}
