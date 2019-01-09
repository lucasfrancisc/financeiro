package controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.FabricaEntityManagerFactory;
import model.dao.database.jpa.TituloDAO;
import model.entity.Titulo;
import util.FuncoesUtil;
import util.enumeration.Operacao;

@Resource
public class TituloController {
	
	private Result result;		
	private final EntityManager manager;
	private final TituloDAO dao;
		
	public TituloController(Result result) {
		this.result = result;
		this.manager = FabricaEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		dao = new TituloDAO(manager);
	}
	
	public void inclui() {
		Titulo entity = new Titulo();
		entity.setOperacao(Operacao.INCLUSAO);
		result.include("entity", entity);
	}
	
	public void exibi(Long id) {
		this.exibirUpdate(id, Operacao.EXIBICAO);
	}
	
	public void altera(Long id) {
		this.exibirUpdate(id, Operacao.ALTERACAO);
	}
	
	private void exibirUpdate(Long id, Operacao operacao) {
		Titulo entity = dao.read(id);
		entity.setOperacao(operacao);
		result.include("entity", entity);
	}
	
	public void grava(Titulo entity) {
		try {
			FuncoesUtil.iniciaTransacao(manager);
			
			if (entity.getOperacao().equals(Operacao.INCLUSAO)) {
				dao.create(entity);
				System.out.println("Título incluido com sucesso!");
			} else if (entity.getOperacao().equals(Operacao.ALTERACAO)){
				dao.update(entity);
				System.out.println("Título alterado com sucesso!");
			}
			FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
		}
		
		result.redirectTo(this).lista("");
	}
	
	public void exclui(Long id) {
		try {
			FuncoesUtil.iniciaTransacao(manager);
			
			dao.delete(id);
			
			FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
		}
		
		result.redirectTo(this).lista("");
	}
	
	public void lista(String pesquisa) {
		List<Titulo> entitys = dao.find(pesquisa);
		result.include("entitys", entitys);
		result.include("pesquisa", pesquisa);
	}
	
}
