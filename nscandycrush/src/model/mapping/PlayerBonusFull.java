package model.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import common.model.dao.HibernateModel;

@Entity
@Table(name="playerbonusview")
public class PlayerBonusFull extends HibernateModel
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlayerBonus;
	private Long idPlayer;
	private Long idBonus;
	private Integer number;
	
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String idFacebook;
	private String bonusName;
	private String bonusDescription;
	public Long getIdPlayerBonus() {
		return idPlayerBonus;
	}
	public void setIdPlayerBonus(Long idPlayerBonus) {
		this.idPlayerBonus = idPlayerBonus;
	}
	public Long getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}
	public Long getIdBonus() {
		return idBonus;
	}
	public void setIdBonus(Long idBonus) {
		this.idBonus = idBonus;
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
	public String getBonusName() {
		return bonusName;
	}
	public void setBonusName(String bonusName) {
		this.bonusName = bonusName;
	}
	public String getBonusDescription() {
		return bonusDescription;
	}
	public void setBonusDescription(String bonusDescription) {
		this.bonusDescription = bonusDescription;
	}
	public PlayerBonusFull(Long idPlayerBonus, Long idPlayer, Long idBonus, Integer number, String nom, String prenom,
			String email, String telephone, String idFacebook, String bonusName, String bonusDescription) {
		super();
		this.idPlayerBonus = idPlayerBonus;
		this.idPlayer = idPlayer;
		this.idBonus = idBonus;
		this.number = number;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.idFacebook = idFacebook;
		this.bonusName = bonusName;
		this.bonusDescription = bonusDescription;
	}
	public PlayerBonusFull() {
		super();
	}
	@Override
	public String toString() {
		return "PlayerBonusFull [idPlayerBonus=" + idPlayerBonus + ", idPlayer=" + idPlayer + ", idBonus=" + idBonus
				+ ", number=" + number + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone="
				+ telephone + ", idFacebook=" + idFacebook + ", bonusName=" + bonusName + ", bonusDescription="
				+ bonusDescription + "]";
	}
	
	
	
	
	
	

}
