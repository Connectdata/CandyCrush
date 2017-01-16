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
@Table(name="session")
public class Session extends HibernateModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSession;
	private Long idPlayer;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private Integer score;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Session(Long idSession, Long idPlayer, Date date, Integer score) {
		super();
		this.idSession = idSession;
		this.idPlayer = idPlayer;
		this.date = date;
		this.score = score;
	}

	public Session() {
		super();
	}

	@Override
	public String toString() {
		return "Session [idSession=" + idSession + ", idPlayer=" + idPlayer + ", date=" + date + ", score=" + score
				+ "]";
	}

	
	
	
	
	
}
