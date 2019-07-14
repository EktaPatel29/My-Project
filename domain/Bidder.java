package com.pcpartpicker.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bidder")
public class Bidder 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bid_id")
	private Long bidId;

	@Column(name = "bid_name")
	private String bidName;

	/*
	 * @Column(name="prodId") private Long prod_Id;
	 */

	
	@Column(name = "price")
	private double price;

	@Column(name = "userId")
	private String userId;
	
	
	
	@ManyToMany(mappedBy="listOfBidders")
	private List<AuctionItem> auctionItems = new ArrayList<AuctionItem>();

	public Bidder() 
	{
	}
	
	public Bidder(long bidId,String bidName,double price,String userId)
	{
		this.bidId=bidId;
		this.price=price;
		this.userId=userId;
		this.bidName=bidName;
	}

	public Bidder(Bidder bid) 
	{
		this.bidId = bid.bidId;
		this.price = bid.price;
		this.bidName = bid.bidName;
		this.userId = bid.userId;
		// this.prod_Id=bid.prod_Id;
	}

	public Bidder(long bidId) 
	{
		this.bidId=bidId;
	}

	public List<AuctionItem> getAuctionItems() {
		return auctionItems;
	}

	public void setAuctionItems(List<AuctionItem> auctionItems) {
		this.auctionItems = auctionItems;
	}

	public void setBidId(Long bidId) 
	{
		this.bidId = bidId;
	}

	public Long getBidId() 
	{
		return bidId;
	}
	
	public void setBidName(String bidName)
	{
		this.bidName = bidName;
	}

	public String getBidName() 
	{
		return bidName;
	}

	/*public Long getProd_Id() 
	{
		return prod_Id;
	}

	public void setProd_Id(Long prod_Id) {
		this.prod_Id = prod_Id;
	}*/

	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public double getPrice() 
	{
		return price;
	}

	public void setUserId(String userId) 
	{
		this.userId = userId;
	}
	
	public String getUserId() 
	{
		return userId;
	}

}
