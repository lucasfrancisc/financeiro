package controller;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.FabricaEntityManagerFactory;
import model.dao.database.jpa.GenericDAO;
import model.entity.Base;
import util.FuncoesUtil;
import util.enumeration.Operacao;
import java.io.File;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GenericController <T extends Base, D extends GenericDAO<T>> {


	private final Class<T> clazz;
	private final Class<D> clazzDAO;
	protected D dao;
	protected final Result result;
	private EntityManager manager;
	private ServletContext context;
	
	@SuppressWarnings("unchecked")
	public GenericController(Result result) {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.clazzDAO = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];  
		this.result = result;
		this.manager = FabricaEntityManagerFactory.getEntityManagerFactory().createEntityManager();
	  
		try {
			dao = clazzDAO.getDeclaredConstructor(EntityManager.class).newInstance(manager);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	 
	public void inclui() {
		T entity = null;
		String Registro = clazz.getName();
		try {
			entity = clazz.newInstance();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		  
		entity.setOperacao(Operacao.INCLUSAO);
		System.out.println(Registro + " gravado com sucesso!");
		result.include("entity", entity);
	}
	
	protected void carregadados(Long id, Operacao operacao) {
		T entity = dao.read(id);
		entity.setOperacao(operacao);
		result.include("entity", entity);		
	}	
		
 	public void exclui(Long id) {
		String Msgem;
		String Registro = clazz.getName();
		this.carregadados(id, Operacao.EXCLUSAO);
		try {
			FuncoesUtil.iniciaTransacao(manager);			
			dao.delete(id);			
			FuncoesUtil.comitaTransacao(manager);
			Msgem = Registro + " excluída(o) com sucesso!";
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
			Msgem = "Erro ao excluir " + Registro + "!";
		}
		System.out.println(Msgem);
		result.redirectTo(this).lista("");	
	}	

	public void grava(T entity) {
		String Msgem = null;
		String Registro = clazz.getName();
		try {
			FuncoesUtil.iniciaTransacao(manager);
			
			if (entity.getOperacao().equals(Operacao.ALTERACAO)){
				dao.update(entity);
				Msgem = Registro + " alterada(o) com sucesso!";
			} else if (entity.getOperacao().equals(Operacao.INCLUSAO)) {
				dao.create(entity);
				Msgem = Registro + " incluída(o) com sucesso!";
			}  
			FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
			Msgem = "Erro ao manipular <" + Registro+">! Operação: " + entity.getOperacao();
		}
		System.out.println(Msgem);	
		result.redirectTo(this).lista("");
	}

	public void lista(String pesquisa) {
		List<T> entitys = dao.find(pesquisa);
		result.include("entitys",entitys);	
		result.include("pesquisa", pesquisa);
	}
	
	public byte[] relatorio(String arquivo) {
		// 1 
		String jasperFile    = "relatorio" + File.separator + arquivo;
		String caminhoJasper = context.getRealPath(jasperFile);
		
		// 2
		List<T> dados = dao.find("");
		
		try {
			// 3
			JasperPrint jasperCompilado = JasperFillManager.fillReport(caminhoJasper, null, new JRBeanCollectionDataSource(dados));
			
			// 4
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperCompilado);
			
			// 5
			return pdf;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
