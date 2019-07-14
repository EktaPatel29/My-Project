package com.pcpartpicker.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Category 
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "category_id")
private int categoryId;

private String categoryName;


@JsonIgnore
@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
private List<Brand> brands;

//@OneToOne(mappedBy="category", cascade = CascadeType.ALL)
//private AuctionItem auctionItem;

public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
//public AuctionItem getAuctionItem() {
//	return auctionItem;
//}
//public void setAuctionItem(AuctionItem auctionItem) {
//	this.auctionItem = auctionItem;
//}

public List<Brand> getBrands() {
	return brands;
}
public void setBrands(List<Brand> brands) {
	this.brands = brands;
}

}
