package com.pcpartpicker.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pcpartpicker.domain.Category;

@Transactional	
public interface CategoryRepository extends JpaRepository<Category, Integer>
	{
	 
	@Modifying
    @Transactional
    @Query("delete from Category u where u.categoryId = ?1")
    void deleteCategoryById(int categoryId);
	   	   
	}
