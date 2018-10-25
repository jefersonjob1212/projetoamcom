package br.com.amcom.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.amcom.dao.iface.LancamentoRepository;
import br.com.amcom.entity.Lancamento;

@ManagedBean(name="lancamentoMB")
@ViewScoped
public class LancamentoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private LancamentoRepository lancamentoRepository;
	
	private Lancamento filtro;
	
	public String getMensagem() {
		return "Isso é um teste";
	}
	
	private List<Lancamento> lista = new ArrayList<Lancamento>();
	
	@PostConstruct
	public void init() {
		this.filtro = new Lancamento();
		this.lista = this.lancamentoRepository.getAll();
	}
}
