package controller;

import model.entity.Base;

public interface GenericInterfaceController<T extends Base> {
	
	public void add();
	
	public void exibir(Long id);
	
	public void update(Long id);
	
	public void save(T entity);
	
	public void excluir(Long id);
	
	public void listagem(String pesquisa);
}
