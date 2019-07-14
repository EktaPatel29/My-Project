package com.pcpartpicker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpartpicker.domain.Bidder;
import com.pcpartpicker.repository.BidderRepository;
import com.pcpartpicker.service.BidderService;

@Service
public class BidderServiceimpl implements BidderService
{
    @Autowired
    BidderRepository bidderRepo;

	@Override
	public Integer getBidCount(Long id)
	{
		return bidderRepo.getBidCount(id);
	}

	@Override
	public List<Bidder> getAllBidder() 
	{
		
		return bidderRepo.findAll();
	}
	
	}

