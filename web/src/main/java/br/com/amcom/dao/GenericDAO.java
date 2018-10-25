package br.com.amcom.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.amcom.dao.iface.GenericRepository;

public abstract class GenericDAO<T, ID extends Serializable> implements GenericRepository<T, ID> {

	protected EntityManager entityManager;
	
	private Class<T> entityClass;
	
	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T salvar(T entity) {
		// TODO Auto-generated method stub
		T saved = null;
		this.entityManager.getTransaction().begin();
		saved = this.entityManager.merge(entity);
		this.entityManager.getTransaction().commit();
		return saved;
	}

	@Override
	public void excluir(T entity) {
		// TODO Auto-generated method stub;
		this.entityManager.remove(entity);
	}

	@Override
	public T getById(Class<T> classe, ID id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(classe, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public List<T> getAll() {
        return this.entityManager.createQuery("SELECT x FROM" 
        		+ getEntityClass().getSimpleName())
        		.getResultList();
    }

	public Class<T> getEntityClass() {
		return entityClass;
	}

	protected void setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub
		
	}
}
