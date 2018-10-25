package br.com.amcom.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.amcom.dao.iface.ItemRepository;
import br.com.amcom.entity.Item;

@ManagedBean(name="itemMB")
@SessionScoped
public class ItemController {
	
	@EJB
	private ItemRepository itemRepository;
	
	private Item filtro;
	
	private List<Item> lista = new ArrayList<Item>();
	
	@PostConstruct
	public void init() {
		this.filtro = new Item();
		this.lista = itemRepository.getAll();
	}
	
	public List<Item> getLista() {
		return lista;
	}
	
	public Item getFiltro() {
		return filtro;
	}
	
	public String getMensagem() {
		return "Lista de Itens Cadastrados";
	}

}
