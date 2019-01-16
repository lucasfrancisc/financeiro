package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.PessoaDAO;
import model.entity.Pessoa;
import util.enumeration.Operacao;

@Resource
public class PessoaController extends GenericController<Pessoa, PessoaDAO>{
	
	public PessoaController(Result result) {
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
	
	public void grava(Pessoa entity) {
		super.grava(entity);
	}	
	
	public void lista(String pesquisa) {
		super.lista(pesquisa);
	}	
}
