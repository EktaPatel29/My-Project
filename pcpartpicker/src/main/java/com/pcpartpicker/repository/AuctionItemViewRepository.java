package com.pcpartpicker.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.pcpartpicker.domain.AuctionItem;


public interface AuctionItemViewRepository extends JpaRepository<AuctionItem,Integer>
{
	@Modifying
	   @Transactional
	   @Query("FROM AuctionItem u where u.category.categoryId= ?1")
       List <AuctionItem> getByCatId(int categoryId);
	
	
	
	   @Query("FROM AuctionItem u where u.auctionItemId= ?1")
	   List <AuctionItem> getAuctionItemById(Long auctionItemId);
	   
	   @Query("Select u.endDate from AuctionItem u where u.auctionItemId= ?1")
	   Date getDate(Long auctionItemId);
	
	   /*@Query("FROM AuctionItem u where u.listOfBidders=?1")
	   Integer getCount(Long auctionItemId);*/



	
}
