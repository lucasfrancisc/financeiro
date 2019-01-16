package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.CentroCustoDAO;
import model.entity.CentroCusto;
import util.enumeration.Operacao;

@Resource
public class CentroCustoController extends GenericController<CentroCusto, CentroCustoDAO>{
	
	public CentroCustoController(Result result) {
		super(result);
	}
	
	public void inclui() {
		super.inclui();
	}
	
	public void exibi(Long id) {
		super.carregadados(id, Operacao.EXIBICAO);
	}
	
	public void altera(Long id) {
		super.carregadados(id, Operacao.ALTERACAO);
	}
	
	public void grava(CentroCusto entity) {
		super.grava(entity);
	}
	
	public void exclui(Long id) {
		super.exclui(id);
	}
	
	public void lista(String pesquisa) {
		super.lista(pesquisa);
	}
	
}
