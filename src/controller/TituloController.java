package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.TituloDAO;
import model.entity.Titulo;
import util.enumeration.Operacao;

@Resource
public class TituloController extends GenericController<Titulo, TituloDAO> implements GenericInterfaceController<Titulo>{
	
	public TituloController(Result result) {
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
	
	public void save(Titulo entity) {
		super.save(entity);
	}
	
	public void excluir(Long id) {
		super.excluir(id);
	}
	
	public void listagem(String pesquisa) {
		super.listagem(pesquisa);
	}
}
