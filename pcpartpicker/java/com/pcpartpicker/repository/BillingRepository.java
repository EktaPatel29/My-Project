package com.pcpartpicker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pcpartpicker.domain.billing;

@Repository
public interface BillingRepository extends JpaRepository<billing, Integer>
{
//	public Bill findById(long Id);
}