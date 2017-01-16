package model.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import common.model.dao.HibernateModel;

@Entity
@Table(name="playerbonus")
public class PlayerBonus extends HibernateModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlayerBonus;
	private Long idPlayer;
	private Long idBonus;
	private Integer number;
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
	public PlayerBonus(Long idPlayerBonus, Long idPlayer, Long idBonus, Integer number) {
		super();
		this.idPlayerBonus = idPlayerBonus;
		this.idPlayer = idPlayer;
		this.idBonus = idBonus;
		this.number = number;
	}
	public PlayerBonus() {
		super();
	}
	@Override
	public String toString() {
		return "PlayerBonus [idPlayerBonus=" + idPlayerBonus + ", idPlayer=" + idPlayer + ", idBonus=" + idBonus
				+ ", number=" + number + "]";
	}
	
	
	
	

}
