package controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.jpa.FinanceiroEntityManagerFactory;
import model.dao.jpa.FormaPagamentoDAO;
import model.entity.FormaPagamento;
import util.FuncoesUtil;
import util.enumeration.Operacao;

@Resource
public class FormaPagamentoController {

	private final Result result;
	private final EntityManager manager;
	private final FormaPagamentoDAO dao;	
	
	public FormaPagamentoController(Result result) {
		this.result = result;	
		this.manager = FinanceiroEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		dao = new FormaPagamentoDAO(manager);		
	}	
	
	@Get("/formaPagamento")
	public void cadastro(){
	
	}

	
	@Get("/formaPagamento/listagem")
	public void listagem() {
		List<FormaPagamento> formas = model.dao.FormaPagamentoDAO.get(); 
		result.include("formas", formas);		
	}
	
	@Post("/formaPagamento")
	public void save(FormaPagamento entity) {
		try {
			FuncoesUtil.iniciaTransacao(manager);
			
			if (entity.getOperacao().equals(Operacao.CREATE)) {
				dao.create(entity);
				System.out.println("Forma de pagamento incluída com sucesso.");
			} else {
				dao.update(entity);
				System.out.println("Forma de pagamento alterada com sucesso.");
			}
			FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
		}
		
		result.redirectTo(this).listagem();
	}
	
	public void exibir(Long id) {
		FormaPagamento entity = dao.read(id);
		result.include("entity", entity);
	}
	
	public void excluir(Long id) {
		try {
			FuncoesUtil.iniciaTransacao(manager);
			
			dao.delete(id);
			
			FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
		}
		
		result.redirectTo(this).listagem();
	}	
	
}