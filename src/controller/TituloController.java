package controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.TituloDAO;
import model.entity.Titulo;
import util.enumeration.Operacao;

@Resource
public class TituloController extends GenericController<Titulo, TituloDAO> {
		
	public TituloController(Result result) {
		super(result);		
	}
	
	public void add() {
		super.add();		
	}
	
	public void exibir(Long id) {
		this.exibirUpdate(id, Operacao.EXIBICAO);
	}
	
	public void update(Long id) {
		this.exibirUpdate(id, Operacao.ALTERACAO);
	}
	
	private void exibirUpdate(Long id, Operacao operacao) {
		Titulo entity = dao.read(id);
		entity.setOperacao(operacao);
		result.include("entity", entity);
	}
	
//	public void save(Titulo entity) {
//		try {
//			FuncoesUtil.iniciaTransacao(manager);
//			
//			if (entity.getOperacao().equals(Operacao.INCLUSAO)) {
//				dao.create(entity);
//				System.out.println("T�tulo incluido com sucesso!");
//			} else if (entity.getOperacao().equals(Operacao.ALTERACAO)){
//				dao.update(entity);
//				System.out.println("T�tulo alterado com sucesso!");
//			}
//			FuncoesUtil.comitaTransacao(manager);
//		} catch(Exception e) {
//			FuncoesUtil.cancelaTransacao(manager);
//		}
//		
//		result.redirectTo(this).listagem("");
//	}
//	
//	public void excluir(Long id) {
//		try {
//			FuncoesUtil.iniciaTransacao(manager);
//			
//			dao.delete(id);
//			
//			FuncoesUtil.comitaTransacao(manager);
//		} catch(Exception e) {
//			FuncoesUtil.cancelaTransacao(manager);
//		}
//		
//		result.redirectTo(this).listagem("");
//	}
	
	public void listagem(String pesquisa) {
		List<Titulo> entitys = dao.find(pesquisa);
		result.include("entitys", entitys);
		result.include("pesquisa", pesquisa);
	}
	
}
