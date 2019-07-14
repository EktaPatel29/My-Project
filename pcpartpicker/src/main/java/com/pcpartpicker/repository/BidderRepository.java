package com.pcpartpicker.repository;

import org.springframework.data.repository.CrudRepository;

import com.pcpartpicker.domain.Bidder;
import com.pcpartpicker.domain.User;

public interface BidderRepository extends CrudRepository<Bidder,Long>
{
	public Bidder findByBidName(String bidName);
	
	public Bidder findByUserId(String userId);

}
