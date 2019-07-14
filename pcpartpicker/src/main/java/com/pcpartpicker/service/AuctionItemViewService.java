package com.pcpartpicker.service;

import java.util.Date;
import java.util.List;

import com.pcpartpicker.domain.AuctionItem;

public interface AuctionItemViewService 
{
	public List<AuctionItem> getByCatId(int id);
	
	public List<AuctionItem> getAuctionItemById(Long id);
	
	public Date getDate(Long id);

    //public Integer getCount(Long id);
}
