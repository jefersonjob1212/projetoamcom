package br.com.amcom.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.Range;

@ManagedBean(name="intersecaoMB")
@ViewScoped
public class IntersecaoController {
	
	private Integer number1;
	
	private Integer number2;
	
	private Integer number3;
	
	private Integer number4;
	
	@PostConstruct
	public void init() {
		setInitialNumbers();
	}
	
	public void verificar(ActionEvent actionEvent) {
		FacesMessage message;
		Range<Integer> range1 = Range.between(number1, number2);
		Range<Integer> range2 = Range.between(number3, number4);
		if(range1.contains(range2.getMaximum()) || range1.contains(range2.getMinimum())) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Existe Interseção entre as faixas 1 e 2", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Não há Interseção entre as faixas 1 e 2.", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public String getTitle() {
		return "Interseção de Números";
	}

	private void setInitialNumbers() {
		// TODO Auto-generated method stub
		setNumber1(0);
		setNumber2(0);
		setNumber3(0);
		setNumber4(0);
	}

	public Integer getNumber1() {
		return number1;
	}

	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}

	public Integer getNumber2() {
		return number2;
	}

	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}

	public Integer getNumber3() {
		return number3;
	}

	public void setNumber3(Integer number3) {
		this.number3 = number3;
	}

	public Integer getNumber4() {
		return number4;
	}

	public void setNumber4(Integer number4) {
		this.number4 = number4;
	}
}
