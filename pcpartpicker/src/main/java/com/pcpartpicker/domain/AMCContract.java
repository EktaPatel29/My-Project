package com.pcpartpicker.domain;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "amcs")
public class AMCContract {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String typeofcontract;
	private String period;
	private int dateofcontract;
	private int dateofexpiry;
	private String product;
	private int quantity;
	private int cost;

	
	
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




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getTypeofcontract() {
		return typeofcontract;
	}




	public void setTypeofcontract(String typeofcontract) {
		this.typeofcontract = typeofcontract;
	}




	public String getPeriod() {
		return period;
	}




	public void setPeriod(String period) {
		this.period = period;
	}




	public int getDateofcontract() {
		return dateofcontract;
	}




	public void setDateofcontract(int dateofcontract) {
		this.dateofcontract = dateofcontract;
	}




	public int getDateofexpiry() {
		return dateofexpiry;
	}




	public void setDateofexpiry(int dateofexpiry) {
		this.dateofexpiry = dateofexpiry;
	}




	public String getProduct() {
		return product;
	}




	public void setProduct(String product) {
		this.product = product;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public int getCost() {
		return cost;
	}




	public void setCost(int cost) {
		this.cost = cost;
	}




	
	
	

	public AMCContract() {
	}

}
