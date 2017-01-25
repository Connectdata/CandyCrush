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
	private Long idBonus;
	private String name;
	private String description;
	private Integer price;
	public Long getIdBonus() {
		return idBonus;
	}
	public void setIdBonus(Long idBonus) {
		this.idBonus = idBonus;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Bonus(Long idBonus, String name, String description, Integer price) {
		super();
		this.idBonus = idBonus;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Bonus() {
		super();
	}
	@Override
	public String toString() {
		return "Bonus [idBonus=" + idBonus + ", name=" + name + ", description=" + description + ", price=" + price
				+ "]";
	}
	
	
	
}
