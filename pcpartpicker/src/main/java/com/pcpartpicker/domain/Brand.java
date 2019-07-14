package com.pcpartpicker.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Brand 
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "brand_id")
private int brandId;


private String brandName;

@ManyToOne(optional = false)
@JoinColumn(name = "categoryId")   //categoryId works as foreign key
private Category category;	

@JsonIgnore
@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
private List<Product> products;



public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public List<Product> getProducts() {
	return products;
}
public void setProducts(List<Product> products) {
	this.products = products;
}



public int getBrandId() {
	return brandId;
}
public void setBrandId(int brandId) {
	this.brandId = brandId;
}
public String getBrandName() {
	return brandName;
}
public void setBrandName(String brandName) {
	this.brandName = brandName;
}



}
