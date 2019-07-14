package com.pcpartpicker.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Address {
	
	private String city;
	private String state;
	private String country;
	private int postCode;
	
	
	
	private String streetAdd;
	public String getStreetAdd() {
		return streetAdd;
	}
	public void setStreetAdd(String streetAdd) {
		this.streetAdd = streetAdd;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	
	

}
