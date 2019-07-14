package com.pcpartpicker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpartpicker.domain.AuctionItem;
import com.pcpartpicker.repository.AuctionItemViewRepository;
import com.pcpartpicker.service.AuctionItemViewService;

@Service
public class AuctionItemViewServiceimpl implements AuctionItemViewService
{

	@Autowired
	AuctionItemViewRepository auctionItemViewrepo;
	@Override
	public List<AuctionItem> getByCatId(int id) 
	{
		
		return auctionItemViewrepo.getByCatId(id);
	}
	
	@Override
	public List<AuctionItem> getAuctionItemById(Long id) 
	{
		
		return auctionItemViewrepo.getAuctionItemById(id);
	}

	@Override
	public Date getDate(Long id) 
	{
		
		return auctionItemViewrepo.getDate(id);
	}

	/*@Override
	public Integer getCount(Long id)
	{	
		return auctionItemViewrepo.getCount(id);
	}*/

	

	

	

}
