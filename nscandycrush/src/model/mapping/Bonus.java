package model.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import common.model.dao.HibernateModel;
@Entity
@Table(name="bonus")
public class Bonus extends HibernateModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBbonus;
	private String name;
	private String description;
	public Long getIdBbonus() {
		return idBbonus;
	}
	public void setIdBbonus(Long idBbonus) {
		this.idBbonus = idBbonus;
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
	public Bonus(Long idBbonus, String name, String description) {
		super();
		this.idBbonus = idBbonus;
		this.name = name;
		this.description = description;
	}
	public Bonus() {
		super();
	}
	@Override
	public String toString() {
		return "Bonus [idBbonus=" + idBbonus + ", name=" + name + ", description=" + description + "]";
	}
	
	
	
	

}
