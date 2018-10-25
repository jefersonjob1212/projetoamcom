package br.com.amcom.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.amcom.dao.iface.ItemRepository;
import br.com.amcom.entity.Item;

@Stateless
@Local(ItemRepository.class)
public class ItemDAO extends GenericDAO<Item, Long> implements ItemRepository {
	
	public ItemDAO() {
		// TODO Auto-generated constructor stub
		super(Item.class);
	}

}
