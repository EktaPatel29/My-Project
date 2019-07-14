package com.pcpartpicker.service;

import java.util.List;

import com.pcpartpicker.domain.AuctionItem;


public interface AuctionItemService
{ 
	public List<AuctionItem> getAllAuctionItem();
	public void deleteAuctionItemById(Long id);
}

