package com.pcpartpicker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pcpartpicker.domain.AMCContract;
@Repository

public interface AmcformRepository extends JpaRepository<AMCContract, Long> {
	
	

	

	
}
