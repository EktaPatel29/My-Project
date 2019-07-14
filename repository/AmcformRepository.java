package com.pcpartpicker.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pcpartpicker.domain.AMCContract;
@Repository

public interface AmcformRepository extends JpaRepository<AMCContract, Long> {
	
	

	@Modifying
    @Transactional
    @Query("delete from AMCContract u where u.id = ?1")
    void deleteAmcById(long id);


	
}
