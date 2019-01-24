package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.entity.FormaPagamento;
import model.dao.database.jpa.FormaPagamentoDAO;
import util.enumeration.Operacao;

@Resource
public class FormaPagamentoController extends GenericController<FormaPagamento, FormaPagamentoDAO> implements GenericInterfaceController<FormaPagamento>{
	
	public FormaPagamentoController(Result result) {
		super(result);
	}
	
	public void add() {
		super.add();
	}
	
	public void exibir(Long id) {
		super.exibirUpdate(id, Operacao.EXIBICAO);
	}
	
	public void update(Long id) {
		super.exibirUpdate(id, Operacao.ALTERACAO);
	}
	
	public void save(FormaPagamento entity) {
		super.save(entity);
	}
	
	public void excluir(Long id) {
		super.excluir(id);
	}
	
	public void listagem(String pesquisa) {
		super.listagem(pesquisa);
	}
}
