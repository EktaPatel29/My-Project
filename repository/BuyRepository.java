package com.pcpartpicker.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pcpartpicker.domain.Buyer;


@Repository
public interface BuyRepository extends JpaRepository<Buyer, Integer> {
	
//	public Buyer findBybuyerId(long buyerId);
	
	@Modifying
    @Transactional
    @Query("delete from Buyer u where u.buyerId = ?1")
    void deleteBuyerById(long buyerId);
}
