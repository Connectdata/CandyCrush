package model.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import common.model.dao.HibernateModel;

@Entity
@Table(name="gametype")
public class GameType extends HibernateModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idGameType;
	String name;
	String description;
	public Long getIdGameType() {
		return idGameType;
	}
	public void setIdGameType(Long idGameType) {
		this.idGameType = idGameType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public GameType(Long idGameType, String name, String description) {
		super();
		this.idGameType = idGameType;
		this.name = name;
		this.description = description;
	}
	public GameType() {
		super();
	}
	@Override
	public String toString() {
		return "GameType [idGameType=" + idGameType + ", name=" + name + ", description=" + description + "]";
	}
	
	
	
	
	
	
	
}
