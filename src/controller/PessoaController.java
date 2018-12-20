package controller;

import java.util.List;

import javax.persistence.EntityManager;
import model.dao.database.jdbc.DatabaseUtil;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.FabricaEntityManagerFactory;
import model.dao.database.jpa.PessoaDAO;
import model.entity.Pessoa;
import util.FuncoesUtil;
import util.enumeration.Operacao;
import javax.persistence.Query;

@Resource
public class PessoaController {
	
	private Result result;	
	private final EntityManager manager;
	private final PessoaDAO dao;
	
	public PessoaController(Result result) {
		this.result = result;
		this.manager = FabricaEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		dao = new PessoaDAO(manager);
	}
	
	public void add() {
		Pessoa entity = new Pessoa();
		entity.setOperacao(Operacao.INCLUSAO);
		result.include("entity", entity);
	}
	
	public void exibir(Long id) {
		this.exibirUpdate(id, Operacao.EXIBICAO);
	}
	
	private void exibirUpdate(Long id, Operacao operacao) {
		Pessoa entity = dao.read(id);
		entity.setOperacao(operacao);
		result.include("entity", entity);
	}	
	
	public void save(Pessoa entity) {
		try {
			FuncoesUtil.iniciaTransacao(manager);
			
			if (entity.getOperacao().equals(Operacao.INCLUSAO)) {
				dao.create(entity);
				System.out.println("Pessoa incluido com sucesso!");
			} else if (entity.getOperacao().equals(Operacao.ALTERACAO)){
				dao.update(entity);
				System.out.println("Pessoa alterado com sucesso!");
			}
			FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
		}
		
		result.redirectTo(this).listagem("");
	}
	
	
	public void excluir(Long id) {
		try {
			FuncoesUtil.iniciaTransacao(manager);
			
			dao.delete(id);
			
			FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
		}
		
		result.redirectTo(this).listagem("");
	}
	
//	public void listagem(String pesquisa) {
//		List<Pessoa> entitys = dao.find(pesquisa);
//		result.include("entitys", entitys);
//		result.include("pesquisa", pesquisa);
//	}
	
	public void listagem(String pesquisa) {
		List<Pessoa> qry = manager.createQuery("Select p From Pessoa as p order by p.id").getResultList();
		result.include("qry", qry);
	}
	
	public void localiza(String pesquisa) {
		List<Pessoa> qry = manager.createQuery("Select p From Pessoa as p order by p.nome").getResultList();
		result.include("qry", qry);
	}
		
	
}
