package controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.CentroCustoDAO;
import model.entity.CentroCusto;
import util.enumeration.Operacao;

@Resource
public class CentroCustoController extends GenericController<CentroCusto, CentroCustoDAO> {
	
	public CentroCustoController(Result result) {
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
		CentroCusto entity = dao.read(id);
		entity.setOperacao(operacao);
		result.include("entity", entity);
	}
	
	public void save(CentroCusto entity) { 
		Operacao op = entity.getId() != null ? Operacao.ALTERACAO : Operacao.INCLUSAO;
		super.save(entity, op);
	}
	
	public void listagem(String pesquisa) {
		List<CentroCusto> entitys = dao.find(pesquisa);
		result.include("entitys", entitys);
		result.include("pesquisa", pesquisa);
	}
	
}
