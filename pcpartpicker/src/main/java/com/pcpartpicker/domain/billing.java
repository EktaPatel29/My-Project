package com.pcpartpicker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="bill")
public class billing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private long Id;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "rate")
	private int rate;
	
	@Column(name = "per")
	private int per;

	@Column(name = "amount")
	private double amount;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "buyerId")
	private Buyer buy;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public int getQuantity() {
		return quantity;
	}
    public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int isPer() {
		return per;
	}
	public void setPer(int per) {
		this.per = per;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
    public Buyer getBuy() {
		return buy;
	}
    public void setBuy(Buyer buy) {
		this.buy = buy;
	}
    
    public billing(){}
	public billing(int quantity, int per, double amount, String description) {
	    	
	    this.quantity=quantity;
	    this.per=per;
	    this.amount=amount;
	    this.description=description;;
	}

  }

	

	

	

