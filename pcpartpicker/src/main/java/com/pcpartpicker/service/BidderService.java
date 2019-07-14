package com.pcpartpicker.service;

import java.util.List;

import com.pcpartpicker.domain.Bidder;

public interface BidderService 
{
	public List<Bidder> getAllBidder();
	public Integer getBidCount(Long id);
}
