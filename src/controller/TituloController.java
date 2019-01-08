package controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.TituloDAO;
import model.entity.Titulo;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.enumeration.Operacao;

@Resource
public class TituloController extends GenericController<Titulo, TituloDAO> implements GenericInterfaceController<Titulo>{
	
	private final ServletContext context;
	
	public TituloController(Result result, ServletContext context) {
		super(result);
		this.context = context;
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
	
	public byte[] relatorio() {
		String path = "relatorios" + File.separator + "titulos.jasper";
		String caminhoJasper = context.getRealPath(path);
		
		List<Titulo> list = dao.find("");
		try {
			JasperPrint impressao = JasperFillManager.fillReport(caminhoJasper, null, new JRBeanCollectionDataSource(list)); 			
			byte[] pdf = JasperExportManager.exportReportToPdf(impressao);			
			return pdf;
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return null;		
	}
}
