package com.promineotech.storeApp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Recipe {

	private Long id;
	private String name;
	private Set<Flavor> flavors;
	private Percentage percentage;


	
	
	@JsonIgnore
	private Set<Order> orders;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "recipe_order",
			joinColumns = @JoinColumn(name = "recipeId", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "orderId", referencedColumnName = "id"))
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "recipe_flavor",
	joinColumns = @JoinColumn(name = "flavorId", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "recipeId", referencedColumnName = "id"))
	public Set<Flavor> getFlavors() {
		return flavors;
	}

	public void setFlavors(Set<Flavor> flavors) {
		this.flavors = flavors;
	}

	public Percentage getPercentage() {
		return percentage;
	}

	public void setPercentage(Percentage percentage) {
		this.percentage = percentage;
	}

}
