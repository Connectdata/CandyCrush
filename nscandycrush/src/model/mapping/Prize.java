package model.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import common.model.dao.HibernateModel;

@Entity
@Table(name="prize")
public class Prize extends HibernateModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrize;
	private String nom;
	private Integer point;
	public Prize(Long idPrize, String nom, Integer point) {
		super();
		this.idPrize = idPrize;
		this.nom = nom;
		this.point = point;
	}
	public Prize() {
		super();
	}
	public Long getIdPrize() {
		return idPrize;
	}
	public void setIdPrize(Long idPrize) {
		this.idPrize = idPrize;
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
	@Override
	public String toString() {
		return "Prize [idPrize=" + idPrize + ", nom=" + nom + ", point=" + point + "]";
	}
	
	
}
