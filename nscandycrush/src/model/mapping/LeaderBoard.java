package model.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import common.model.dao.HibernateModel;

@Entity
@Table(name="leaderboard")
public class LeaderBoard extends HibernateModel
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idSession;
	Integer score;
	String date;
	Long idGameType;
	Long idPlayer;
	String nom;
	String prenom;
	String telephone;
	String email;
	Integer point;
	String idFacebook;
	String gameTypeName;
	String description;
	public Long getIdSession() {
		return idSession;
	}
	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getIdGameType() {
		return idGameType;
	}
	public void setIdGameType(Long idGameType) {
		this.idGameType = idGameType;
	}
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getIdFacebook() {
		return idFacebook;
	}
	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	}
	public String getGameTypeName() {
		return gameTypeName;
	}
	public void setGameTypeName(String gameTypeName) {
		this.gameTypeName = gameTypeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LeaderBoard(Long idSession, Integer score, String date, Long idGameType, Long idPlayer, String nom,
			String prenom, String telephone, String email, Integer point, String idFacebook, String gameTypeName,
			String description) {
		super();
		this.idSession = idSession;
		this.score = score;
		this.date = date;
		this.idGameType = idGameType;
		this.idPlayer = idPlayer;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.point = point;
		this.idFacebook = idFacebook;
		this.gameTypeName = gameTypeName;
		this.description = description;
	}
	public LeaderBoard() {
		super();
	}
	@Override
	public String toString() {
		return "LeaderBoard [idSession=" + idSession + ", score=" + score + ", date=" + date + ", idGameType="
				+ idGameType + ", idPlayer=" + idPlayer + ", nom=" + nom + ", prenom=" + prenom + ", telephone="
				+ telephone + ", email=" + email + ", point=" + point + ", idFacebook=" + idFacebook + ", gameTypeName="
				+ gameTypeName + ", description=" + description + "]";
	}
	
	
	

}
