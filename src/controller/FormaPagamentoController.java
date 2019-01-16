package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.FormaPagamentoDAO;
import model.entity.FormaPagamento;
import util.enumeration.Operacao;

@Resource
public class FormaPagamentoController extends GenericController<FormaPagamento, FormaPagamentoDAO>{
	
	public FormaPagamentoController(Result result) {
		super(result);		
	}	
	
	public void inclui() {
		super.inclui();
	}
	
	public void exibi(Long id){
		super.carregadados(id, Operacao.EXIBICAO);
	}
	
	public void altera(Long id){
		super.carregadados(id, Operacao.ALTERACAO);
	}	
	
	public void exclui(Long id) {
		super.exclui(id);		
	}	
	
	public void grava(FormaPagamento entity) {
		super.grava(entity);
	}
	
	public void lista(String pesquisa) {
		super.lista(pesquisa);
	}	
	
}