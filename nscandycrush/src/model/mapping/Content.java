package model.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import common.model.dao.HibernateModel;

@Entity
@Table(name="content")
public class Content extends HibernateModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContent;
	private Long idPrize;
	private Long idAgency;
	private Integer number;
	public Long getIdContent() {
		return idContent;
	}
	public void setIdContent(Long idContent) {
		this.idContent = idContent;
	}
	public Long getIdPrize() {
		return idPrize;
	}
	public void setIdPrize(Long idPrize) {
		this.idPrize = idPrize;
	}
	public Long getIdAgency() {
		return idAgency;
	}
	public void setIdAgency(Long idAgency) {
		this.idAgency = idAgency;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Content(Long idContent, Long idPrize, Long idAgency, Integer number) {
		super();
		this.idContent = idContent;
		this.idPrize = idPrize;
		this.idAgency = idAgency;
		this.number = number;
	}
	public Content() {
		super();
	}
	@Override
	public String toString() {
		return "Content [idContent=" + idContent + ", idPrize=" + idPrize + ", idAgency=" + idAgency + ", number="
				+ number + "]";
	}
	
	
	
	
	
	
	
	

}
