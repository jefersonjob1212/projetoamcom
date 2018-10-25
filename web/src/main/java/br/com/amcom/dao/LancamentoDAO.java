package br.com.amcom.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.amcom.dao.iface.LancamentoRepository;
import br.com.amcom.entity.Lancamento;

@Stateless
@Local(LancamentoRepository.class)
public class LancamentoDAO 
	extends GenericDAO<Lancamento, Long> implements LancamentoRepository {
	
	public LancamentoDAO() {
		// TODO Auto-generated constructor stub
		super(Lancamento.class);
	}
}
