package com.pcpartpicker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcpartpicker.domain.AuctionItem;
import com.pcpartpicker.domain.Bidder;
import com.pcpartpicker.repository.AuctionItemRepository;

@Controller
public class AuctionItemController 
{
   @Autowired
   AuctionItemRepository auctionItemrepo;
   
   @RequestMapping("/addProduct")
	@ResponseBody
	public String addProduct(String name,double price,String spec,int cat)
	{
		AuctionItem at=null;
		try
		{
			at=new AuctionItem(name,price,spec,cat);
			auctionItemrepo.save(at);
		}
		catch(Exception ex)
		{
			return "Error adding Auction Items: " + ex.toString();
		}
		return "Item succesfully added! (id = " + at.getAuctionItemName()+ ")";
	}
   
   @RequestMapping("/deleteProduct")
	  @ResponseBody
	  public String deleteProduct(long auctionItemId)
	  {
	    AuctionItem at=null;
	    try 
	    {
	       at=new AuctionItem(auctionItemId);
	      auctionItemrepo.delete(at);
	    }
	    catch (Exception ex) 
	    {
	      return "Error deleting the product:" + ex.toString();
	    }
	    return "Product succesfully deleted!";
	  }
   
   @RequestMapping("/updateProduct")
	  @ResponseBody
	  public String updateProduct(long auctionItemId,String name,double price,String spec,int cat) 
	  {
	    try 
	    {
	      AuctionItem ai = auctionItemrepo.findOne(auctionItemId);
	      ai.setAuctionItemName(name);
	      ai.setAuctionItemPrice(price);
	      ai.setSpec(spec);
	      ai.setAuctionProdCat(cat);
	      auctionItemrepo.save(ai);
	    }
	    catch (Exception ex)
	    {
	      return "Error updating the product details: " + ex.toString();
	    }
	    return "Product details succesfully updated!";
	  }
}
