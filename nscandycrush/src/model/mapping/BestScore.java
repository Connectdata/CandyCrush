package model.mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import common.model.dao.HibernateModel;

@Entity
@Table(name="bestScore")
public class BestScore extends HibernateModel
{
	
	@Id
	private Long idPlayer;
	
	private String nom;
	private String prenom;
	private Integer score;
	private Integer rank;
	public Long getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public BestScore(Long idPlayer, String nom, String prenom, Integer score, Integer rank) {
		super();
		this.idPlayer = idPlayer;
		this.nom = nom;
		this.prenom = prenom;
		this.score = score;
		this.rank = rank;
	}
	public BestScore() {
		super();
	}
	@Override
	public String toString() {
		return "BestScore [idPlayer=" + idPlayer + ", nom=" + nom + ", prenom=" + prenom + ", score=" + score
				+ ", rank=" + rank + "]";
	}
	
	
	
	
	
	
	

}
