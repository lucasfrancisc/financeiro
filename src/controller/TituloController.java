package controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.PessoaDAO;
import model.dao.database.jpa.TituloDAO;
import model.entity.Titulo;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.FuncoesUtil;
import util.enumeration.Operacao;

@Resource
public class TituloController extends GenericController<Titulo, TituloDAO> {
		
	private ServletContext context;
	
	public TituloController(Result result, ServletContext context) {		
		super(result);		
		this.context = context;
	}
	
	public void add() {
		super.add();
		PessoaDAO pDAO = new PessoaDAO(manager);
		result.include("listaPessoas", pDAO.find(""));
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
	
	public void save(Titulo entity) {
		try {
			FuncoesUtil.iniciaTransacao(manager);
			
			if (entity.getOperacao().equals(Operacao.INCLUSAO)) {
				dao.create(entity);
				System.out.println("Título incluido com sucesso!");
			} else if (entity.getOperacao().equals(Operacao.ALTERACAO)){
				dao.update(entity);
				System.out.println("Título alterado com sucesso!");
			}
			FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
		}
		
		result.redirectTo(this).listagem("");
	}
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
	
	@Path("/")
	public void listagem(String pesquisa) {
		List<Titulo> entitys = dao.find(pesquisa);
		result.include("entitys", entitys);
		result.include("pesquisa", pesquisa);
	}
	
	public byte[] relatorio() {
		// 1 
		String jasperFile = "relatorios" + File.separator + "titulo-teste.jasper";
		String caminhoJasper = context.getRealPath(jasperFile);
		
		// 2
		List<Titulo> titulos = dao.find("");
		
		try {
			// 3
			JasperPrint jasperCompilado = JasperFillManager.fillReport(caminhoJasper, null, new JRBeanCollectionDataSource(titulos));
			
			// 4
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperCompilado);
			
			// 5
			return pdf;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
