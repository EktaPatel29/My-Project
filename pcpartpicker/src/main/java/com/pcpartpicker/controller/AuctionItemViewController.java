package com.pcpartpicker.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcpartpicker.domain.AuctionItem;
import com.pcpartpicker.repository.AuctionItemViewRepository;
import com.pcpartpicker.service.AuctionItemViewService;

@Controller
public class AuctionItemViewController 
{
	 @Autowired
	   AuctionItemViewRepository auctionItemViewrepo;
	   
	   @Autowired
	   AuctionItemViewService auctionItemViewser;
	
	@RequestMapping("/auctionindex")
	public String page1()
	{
		return "auctionview";
	}
	
	@RequestMapping("/auctiondisp")
	public String display()
	{
		return "auctiondisplay";
	}
	
	
	@RequestMapping(value="/getItemById/{id}",method=RequestMethod.GET)
    @ResponseBody
    public List<AuctionItem> getItemById(@PathVariable("id") int id)
    {
		
		return auctionItemViewser.getByCatId(id);
    	
    }
	
	@RequestMapping(value="/getAuctionItemById/{id}",method=RequestMethod.GET)
    @ResponseBody
    public List<AuctionItem> getAuctionItemById(@PathVariable("id") Long id)
    {
		
		return auctionItemViewser.getAuctionItemById(id);
    	
    }
	
	@RequestMapping(value="/getDate/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Date getDate(@PathVariable("id") Long id)
    {
		
		return auctionItemViewser.getDate(id);
    	
    }
	
}
