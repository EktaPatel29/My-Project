package com.pcpartpicker.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcpartpicker.domain.AuctionItem;
import com.pcpartpicker.domain.Bidder;
import com.pcpartpicker.repository.AuctionItemRepository;
import com.pcpartpicker.repository.BidderRepository;

@Controller
public class BidderController 
{
	@Autowired
	BidderRepository bidRepo;
	
	@RequestMapping("/bidder")
	  
	  public String index() {
	    return "bidder" ;
	}
	//AuctionItemRepository atrepo;
	@RequestMapping("/createBidder")
    @ResponseBody
	public String createBidder(long bidId,String bidName,double price,String userId) 
	{
	    Bidder bidder=null;
	    try 
	    {
	      bidder = new Bidder(bidId,bidName,price,userId);
	      bidRepo.save(bidder);
	    }
	    catch (Exception ex) 
	    {
	      return "Error adding Bidder: " + ex.toString();
	    }
	    return "Bidder succesfully added! (id = " + bidder.getUserId()+ ")";
	  }
	
	
	
	@RequestMapping("/deleteBidder")
	  @ResponseBody
	  public String deleteBidder(long bidId)
	  {
	    try 
	    {
	      Bidder bidder = new Bidder(bidId);
	      bidRepo.delete(bidder);
	    }
	    catch (Exception ex) 
	    {
	      return "Error deleting the bidder:" + ex.toString();
	    }
	    return "Bidder succesfully deleted!";
	  }
	
	  @RequestMapping("/get-by-user-id")
	  @ResponseBody
	  public String getByUserId(String userId)
	  {
	    String bidId = "";
	    try 
	    {
	      Bidder bidder = bidRepo.findByUserId(userId);
	      bidId = String.valueOf(bidder.getUserId());
	    }
	    catch (Exception ex) 
	    {
	      return "User not found";
	    }
	    return "The bidder id is: " + bidId;
	  }
	  
	  @RequestMapping("/updateBidder")
	  @ResponseBody
	  public String updateBidder(long bidId, String bidName,double price,String userId) 
	  {
	    try 
	    {
	      Bidder bidder = bidRepo.findOne(bidId);
	      bidder.setUserId(userId);
	      bidder.setPrice(price);
	      bidder.setBidName(bidName);
	      bidRepo.save(bidder);
	    }
	    catch (Exception ex)
	    {
	      return "Error updating the bidder: " + ex.toString();
	    }
	    return "Bidder succesfully updated!";
	  }
	  
}

