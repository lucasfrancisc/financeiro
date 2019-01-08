package controller;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Result;
import model.dao.database.jpa.FabricaEntityManagerFactory;
import model.dao.database.jpa.GenericDAO;
import model.entity.Base;
import util.FuncoesUtil;
import util.enumeration.Operacao;

public abstract class GenericController <T extends Base, D extends GenericDAO<T>> implements GenericInterfaceController<T> {

	private final Class<T> clazz;
	private final Class<GenericDAO<T>> clazzDAO;
	
	protected final Result result;		
	protected final EntityManager manager;
	protected final D dao;	
	
	@SuppressWarnings("unchecked")
	public GenericController(Result result) {
		this.result = result;
		this.manager = FabricaEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.clazzDAO = (Class<GenericDAO<T>>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		
		try {
			dao = (D) clazzDAO.getDeclaredConstructor(EntityManager.class).newInstance(manager);
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível instanciar o DAO genérico.");
		}
	}
	
	public void add() {
		try {
			T entity = clazz.newInstance();
			entity.setOperacao(Operacao.INCLUSAO);
			result.include("entity", entity);
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível instanciar o model genérico.");
		}
	}
	
	protected void exibirUpdate(Long id, Operacao operacao) {
		T entity = dao.read(id);
		entity.setOperacao(operacao);
		result.include("entity", entity);		
	}
	
	public void save(T entity) {
		try {
			FuncoesUtil.iniciaTransacao(manager);
			
			if (entity.getOperacao().equals(Operacao.INCLUSAO)) {
				dao.create(entity);
				System.out.println("Registro ncluido com sucesso!");
			} else if (entity.getOperacao().equals(Operacao.ALTERACAO)){
				dao.update(entity);
				System.out.println("Registro alterado com sucesso!");
			}
			FuncoesUtil.comitaTransacao(manager);
		} catch(Exception e) {
			FuncoesUtil.cancelaTransacao(manager);
		}
		
		result.redirectTo(this).listagem("");
	}
	
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
		List<T> entitys = dao.find(pesquisa);
		result.include("entitys", entitys);
		result.include("pesquisa", pesquisa);
	}
}
