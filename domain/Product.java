
package com.pcpartpicker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.Table;

@Entity

public class Product 
{
	
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int productId;
 
 private String productName;
 private int productPrice;
 private String productSpecific;
 
 @ManyToOne(optional = false)
 @JoinColumn(name = "brandId")   //brandId works as foreign key
 private Brand brand;	
 
 
 public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
 
 
 
 
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getProductPrice() {
	return productPrice;
}
public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}
public String getProductSpecific() {
	return productSpecific;
}
public void setProductSpecific(String productSpecific) {
	this.productSpecific = productSpecific;
}

	
}
