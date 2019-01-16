package controller;

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

	public void grava(Titulo entity) {
		super.grava(entity);
	}
	
	public void lista(String pesquisa) {
		super.lista(pesquisa);
	}
	
/*	public byte[] relatorio(String arquivo) {
		arquivo = "titulo-teste.jasper";
		super.relatorio(arquivo);
		super.      return pdf;
	}	*/
	
}
