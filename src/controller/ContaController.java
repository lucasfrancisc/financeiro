package controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.ContaDAO;
import model.entity.Conta;
import util.enumeration.Operacao;

@Resource
public class ContaController extends GenericController<Conta, ContaDAO> {
	
	public ContaController(Result result) {
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

	public void grava(Conta entity) {
		super.grava(entity);
	}
	
	public void lista(String pesquisa) {
		super.lista(pesquisa);
	}
	
	@Path("/")
	public void menu() {
	}	
}
