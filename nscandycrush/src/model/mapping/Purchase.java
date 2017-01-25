package model.mapping;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import common.model.dao.HibernateModel;

@Entity
@Table(name="purchase")
public class Purchase extends HibernateModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPurchase;
	private Long idPlayer;
	private Long idBonus;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private Integer number;
	private Integer totalPrice;
	public Long getIdPurchase() {
		return idPurchase;
	}
	public void setIdPurchase(Long idPurchase) {
		this.idPurchase = idPurchase;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Purchase(Long idPurchase, Long idPlayer, Long idBonus, Date date, Integer number, Integer totalPrice) {
		super();
		this.idPurchase = idPurchase;
		this.idPlayer = idPlayer;
		this.idBonus = idBonus;
		this.date = date;
		this.number = number;
		this.totalPrice = totalPrice;
	}
	public Purchase() {
		super();
	}
	@Override
	public String toString() {
		return "Purchase [idPurchase=" + idPurchase + ", idPlayer=" + idPlayer + ", idBonus=" + idBonus + ", date="
				+ date + ", number=" + number + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
	

}
