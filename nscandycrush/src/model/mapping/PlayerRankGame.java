package model.mapping;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import common.model.dao.HibernateModel;
import helper.DateHelper;

public class PlayerRankGame 
{
	
	Long idSession;
	Long idPlayer;
	Integer score;
	String date;
	Integer rank;
	Long idGameType;
	String nom;
	String prenom;
	String email;
	String telephone;
	String idFacebook;
	public Long getIdSession() {
		return idSession;
	}
	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}
	public Long getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
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
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Long getIdGameType() {
		return idGameType;
	}
	public void setIdGameType(Long idGameType) {
		this.idGameType = idGameType;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIdFacebook() {
		return idFacebook;
	}
	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	}
	public PlayerRankGame(Long idSession, Long idPlayer, Integer score, String date, Integer rank, Long idGameType,
			String nom, String prenom, String email, String telephone, String idFacebook) {
		super();
		this.idSession = idSession;
		this.idPlayer = idPlayer;
		this.score = score;
		this.date = date;
		this.rank = rank;
		this.idGameType = idGameType;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.idFacebook = idFacebook;
	}
	public PlayerRankGame() {
		super();
	}
	@Override
	public String toString() {
		return "PlayerRankGame [idSession=" + idSession + ", idPlayer=" + idPlayer + ", score=" + score + ", date="
				+ date + ", rank=" + rank + ", idGameType=" + idGameType + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", telephone=" + telephone + ", idFacebook=" + idFacebook + "]";
	}
	
	
	
	
}
