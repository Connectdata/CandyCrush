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
@Table(name="retrait")
public class Retrait  extends HibernateModel
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRetrait;
	private Long idAgency;
	private Long idPlayer;
	@Temporal(TemporalType.DATE)
	private Date date;
	public Long getIdRetrait() {
		return idRetrait;
	}
	public void setIdRetrait(Long idRetrait) {
		this.idRetrait = idRetrait;
	}
	public Long getIdAgency() {
		return idAgency;
	}
	public void setIdAgency(Long idAgency) {
		this.idAgency = idAgency;
	}
	public Long getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Retrait(Long idRetrait, Long idAgency, Long idPlayer, Date date) {
		super();
		this.idRetrait = idRetrait;
		this.idAgency = idAgency;
		this.idPlayer = idPlayer;
		this.date = date;
	}
	public Retrait() {
		super();
	}
	@Override
	public String toString() {
		return "Retrait [idRetrait=" + idRetrait + ", idAgency=" + idAgency + ", idPlayer=" + idPlayer + ", date="
				+ date + "]";
	}
	
	
	
	
	

}
