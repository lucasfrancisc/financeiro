package controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.PessoaDAO;
import model.entity.Pessoa;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.FuncoesUtil;
import util.enumeration.Operacao;

@Resource
public class PessoaController extends GenericController<Pessoa, PessoaDAO> {
		
	private ServletContext context;
	
	public PessoaController(Result result, ServletContext context) {		
		super(result);		
		this.context = context;
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
		Pessoa entity = dao.read(id);
		entity.setOperacao(operacao);
		result.include("entity", entity);
	}	
	
	public void save(Pessoa entity) {
		try {
			FuncoesUtil.iniciaTransacao(manager);
			
			if (entity.getOperacao().equals(Operacao.INCLUSAO)) {
				dao.create(entity);
				System.out.println("Pessoa incluido com sucesso!");
			} else if (entity.getOperacao().equals(Operacao.ALTERACAO)){
				dao.update(entity);
				System.out.println("Pessoa alterado com sucesso!");
			}
			FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
		}
		
		result.redirectTo(this).listagem("");
	}
//	
//	
	public void excluir(Long id) {
		try {
			FuncoesUtil.iniciaTransacao(manager);
			
			dao.delete(id);
			
			FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
		}
		
		result.redirectTo(this).listagem("");
	}
	
	public void listagem(String pesquisa) {
		List<Pessoa> entitys = dao.find(pesquisa);
		result.include("entitys", entitys);
		result.include("pesquisa", pesquisa);
	}
	
	public void localiza(String pesquisa) {
		List<Pessoa> entitys =  dao.find("");
		result.include("pesquisa", entitys);

	}
	
	public void menu() {
		
	}
	
	public byte[] relatorio() {
		// 1 
		String jasperFile = "relatorios" + File.separator + "ListaPessoa.jasper";
		String caminhoJasper = context.getRealPath(jasperFile);
		
		// 2
		List<Pessoa> pessoa = dao.find("");
		
		try {
			// 3
			JasperPrint jasperCompilado = JasperFillManager.fillReport(caminhoJasper, null, new JRBeanCollectionDataSource(pessoa));
			
			// 4
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperCompilado);
			
			// 5
			return pdf;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
		
	
}
