package br.com.amcom.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="amcom", name="lancamento")
@NamedQueries({
	@NamedQuery(name="Lancamento.getTodos", query="SELECT l FROM Lancamento l")
})
public class Lancamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="lancamento_oid_seq", schema="amcom")
	@GeneratedValue(generator="lancamento_oid_seq", strategy=GenerationType.AUTO)
	private Long oid;
	
	@Column(name="dt_inical", nullable=false)
	private LocalDateTime dtInicial;
	
	@Column(name="dt_final", nullable=false)
	private LocalDateTime dtFinal;
	
	@Column(name="vl_total", nullable=false)
	private BigDecimal vlTotal;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Item> itens = new ArrayList<Item>();

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public LocalDateTime getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(LocalDateTime dtInicial) {
		this.dtInicial = dtInicial;
	}

	public LocalDateTime getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(LocalDateTime dtFinal) {
		this.dtFinal = dtFinal;
	}

	public BigDecimal getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		return true;
	}
}
