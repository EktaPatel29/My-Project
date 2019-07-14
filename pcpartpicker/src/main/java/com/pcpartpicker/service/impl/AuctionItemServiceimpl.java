package com.pcpartpicker.service.impl;

import java.util.List;



//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpartpicker.domain.AuctionItem;
//import com.pcpartpicker.domain.AuctionItem;
import com.pcpartpicker.repository.AuctionItemRepository;
import com.pcpartpicker.service.AuctionItemService;


@Service
public class AuctionItemServiceimpl implements AuctionItemService
{

	@Autowired
	AuctionItemRepository auctionItemrepo;

	@Override
	public List<AuctionItem> getAllAuctionItem()
	{
		return auctionItemrepo.findAll();
	}

	@Override
	public void deleteAuctionItemById(Long id)
	{
		auctionItemrepo.deleteAuctionItemById(id);
		
	}
	
}
