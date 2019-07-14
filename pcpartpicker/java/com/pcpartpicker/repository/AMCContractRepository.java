package com.pcpartpicker.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.pcpartpicker.domain.AmcContractList;


	@Repository
	
	public interface AMCContractRepository extends JpaRepository<AmcContractList, Long> {
		
		//public AMCContract findByEmail(String email);
		@Modifying
	    @Transactional
	    @Query("delete from AmcContractList u where u.type_id = ?1")
	    void deleteAmcById(long type_id);

		

		
	}


