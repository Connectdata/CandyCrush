package model.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import common.model.dao.HibernateModel;

@Entity
@Table(name="agencycontent")
public class AgencyContent  extends HibernateModel
{
	@Id
	Long idAgency;
	Long idContent;
	Long idPrize;
	String commune;
	String quartier;
	String GPS;
	String adress;
	String mark;
	
	Integer number;
	String nom;
	Integer point;
	public Long getIdAgency() {
		return idAgency;
	}
	public void setIdAgency(Long idAgency) {
		this.idAgency = idAgency;
	}
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public AgencyContent(Long idAgency, Long idContent, Long idPrize, String commune, String quartier, String gPS,
			String adress, String mark, Integer number, String nom, Integer point) {
		super();
		this.idAgency = idAgency;
		this.idContent = idContent;
		this.idPrize = idPrize;
		this.commune = commune;
		this.quartier = quartier;
		GPS = gPS;
		this.adress = adress;
		this.mark = mark;
		this.number = number;
		this.nom = nom;
		this.point = point;
	}
	@Override
	public String toString() {
		return "AgencyContent [idAgency=" + idAgency + ", idContent=" + idContent + ", idPrize=" + idPrize
				+ ", commune=" + commune + ", quartier=" + quartier + ", GPS=" + GPS + ", adress=" + adress + ", mark="
				+ mark + ", number=" + number + ", nom=" + nom + ", point=" + point + "]";
	}
	public AgencyContent() {
		super();
	}
	
	
	

}
