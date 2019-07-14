package com.pcpartpicker.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.tomcat.jni.Address;

@Entity
@Table(name = "auctionitem")
public class AuctionItem 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auction_item_id")
	private Long auctionItemId;

	@Column(name = "auction_item_name")
	private String auctionItemName;

	@Column(name = "auction_item_price")
	private double auctionItemPrice;

	@Column(name = "specifications")
	private String spec;

	@Column(name = "auction_prod_cat")
	private int auctionProdCat;

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auction_bidder_join_table", 
        joinColumns = { @JoinColumn(name = "auction_item_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "bid_id") })
    private List<Bidder> listOfBidders = new ArrayList<Bidder>();
	
//	@OneToOne
//	@PrimaryKeyJoinColumn
//	private Category category;
 
	
	
	


	public AuctionItem()
	{
	}

	

	public AuctionItem(AuctionItem ai)
	{
		this.auctionItemId = ai.auctionItemId;
		this.auctionItemName = ai.auctionItemName;
		this.auctionItemPrice = ai.auctionItemPrice;
		this.spec = ai.spec;
		this.auctionProdCat = ai.auctionProdCat;
	}

	public AuctionItem(String auctionItemName, double auctionItemPrice, String spec,int auctionProdCat) 
	{
		this.auctionItemName=auctionItemName;
		this.auctionItemPrice=auctionItemPrice;
		this.spec=spec;
		this.auctionProdCat=auctionProdCat;
	}
	
	public AuctionItem(Long auctionItemId)
	{
		this.auctionItemId=auctionItemId;
	}



	public void setAuctionItemId(Long auctionItemId) 
	{
		this.auctionItemId = auctionItemId;
	}

	public Long getAuctionItemId() 
	{
		return auctionItemId;
	}

	public void setAuctionItemName(String auctionItemName) 
	{
		this.auctionItemName = auctionItemName;
	}
	
	public String getAuctionItemName() 
	{
		return auctionItemName;
	}

	public void setAuctionItemPrice(double auctionItemPrice)
	{
		this.auctionItemPrice = auctionItemPrice;
	}

	public double getAuctionItemPrice() 
	{
		return auctionItemPrice;
	}
	
	public void setSpec(String spec) 
	{
		this.spec = spec;
	}
	
	public String getSpec() 
	{
		return spec;
	}
	
	public void setAuctionProdCat(int auctionProdCat) 
	{
		this.auctionProdCat = auctionProdCat;
	}
	
	public int getAuctionProdCat() 
	{
		return auctionProdCat;
	}



	public List<Bidder> getListOfBidders() 
	{
		return listOfBidders;
	}



	public void setListOfBidders(List<Bidder> listOfBidders)
	{
		this.listOfBidders = listOfBidders;
	}

//	public Category getCategory() {
//		return category;
//	}
//
//
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//

	
	
	
}
