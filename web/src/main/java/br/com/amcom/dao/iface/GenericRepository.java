package br.com.amcom.dao.iface;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<T, ID extends Serializable> {
	
	T salvar(T entity);
	
	void excluir(T entity);
	
	T getById(Class<T> classe, ID id);

	List<T> getAll();
}
