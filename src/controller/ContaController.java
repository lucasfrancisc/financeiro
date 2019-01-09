package controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.ContaDAO;
import model.dao.database.jpa.FabricaEntityManagerFactory;
import model.dao.database.jpa.GenericDAO;
import model.entity.Conta;
import util.FuncoesUtil;
import util.enumeration.Operacao;

@Resource
public class ContaController extends GenericController<Conta, ContaDAO> {
	
	private Result result;
	private final EntityManager manager;	
	private final ContaDAO dao;
	
	public ContaController(Result result) {
		this.result = result;	
		this.manager = FabricaEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		dao = new ContaDAO(manager);
	}

	public void exibi(Long id){
		this.carregadados(id, Operacao.EXIBICAO);
		}
	
	public void altera(Long id){
		this.carregadados(id, Operacao.ALTERACAO);
		}	
	
	public void inclui() {
		Conta entity = new Conta();
		entity.setOperacao(Operacao.INCLUSAO);
		entity.setTipo("caixa");
		entity.setSaldo(0.00);
		result.include("entity", entity);	
	}
	
	public void exclui(Long id) {
		String Msgem;
		this.carregadados(id, Operacao.EXCLUSAO);
		try {
			FuncoesUtil.iniciaTransacao(manager);			
			dao.delete(id);			
			FuncoesUtil.comitaTransacao(manager);
			Msgem = "Conta excluída com sucesso!";
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
			Msgem = "Erro ao excluir conta!";
		}
		System.out.println(Msgem);
		result.redirectTo(this).lista("");		
	}
	
	private void carregadados(Long id, Operacao operacao) {
		Conta entity = dao.read(id);
		entity.setOperacao(operacao);
		result.include("entity", entity);
	}

	public void grava(Conta entity) {
		String Msgem = null;
		try {
			FuncoesUtil.iniciaTransacao(manager);
			
			if (entity.getOperacao().equals(Operacao.ALTERACAO)){
				dao.update(entity);
				Msgem = "Conta <" + entity.getDescricao()+"> alterada com sucesso!";
			} else if (entity.getOperacao().equals(Operacao.INCLUSAO)) {
				dao.create(entity);
				Msgem = "Conta <" + entity.getDescricao()+"> incluída com sucesso!";
			}  
			FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
			Msgem = "Erro ao manipular conta <" + entity.getDescricao()+">! Operação: " + entity.getOperacao();
		}
		System.out.println(Msgem);	
		result.redirectTo(this).lista("");
	}
	
	public void lista(String pesquisa) {
		List<Conta> entitys = dao.find(pesquisa);
		result.include("entitys",entitys);	
		result.include("pesquisa", pesquisa);
	}		
}
