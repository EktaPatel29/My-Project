package com.pcpartpicker.domain;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "buyers")
public class Buyer 
{	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "buyer_id")
    private long buyerId;
	
	@Column(name = "buyer_name") 
	private String buyerName;
	
	@Column(name = "product_name")
	private String productName;

	@Column(name = "amount")
	private int amount;
	
	@Column(name = "quantity")
	private int quantity;
	
	/*@OneToMany(mappedBy = "buy" , cascade = CascadeType.ALL)
	private List<billing> bills;*/
	
    /*public List<billing> getBills() {
		return bills;
	}
	public void setBills(List<billing> bills) {
		this.bills = bills;
	}*/
	
	public long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Buyer(){}
	public Buyer(long buyerId,String buyerName,String productName,int amount,int quantity) {
		this.buyerId=buyerId;
		this.buyerName=buyerName;
		this.productName=productName;
		this.amount=amount;
		this.quantity=quantity;
	}
	public Buyer(long buyerId) {
		this.buyerId=buyerId;
	}	
}
