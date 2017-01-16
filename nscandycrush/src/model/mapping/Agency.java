package model.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import common.model.dao.HibernateModel;


@Entity
@Table(name="achievement")
public class Agency extends HibernateModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAgency;
	private String login;
	private String commune;
	private String quartier;
	private String GPS;
	
	public Agency(Long idAgency, String login, String commune, String quartier, String gPS)
	{
		this.idAgency = idAgency;
		this.login = login;
		this.commune = commune;
		this.quartier = quartier;
		GPS = gPS;
	}

	public Agency() 
	{
		
	}

	public Long getIdAgency() {
		return idAgency;
	}

	public void setIdAgency(Long idAgency) {
		this.idAgency = idAgency;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public String getGPS() {
		return GPS;
	}

	public void setGPS(String gPS) {
		GPS = gPS;
	}

	@Override
	public String toString() {
		return "Agency [idAgency=" + idAgency + ", login=" + login + ", commune=" + commune + ", quartier=" + quartier
				+ ", GPS=" + GPS + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
