package com.pcpartpicker.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pcpartpicker.domain.Brand;
//import com.pcpartpicker.domain.Category;

@Transactional
public interface BrandRepository extends JpaRepository<Brand,Integer>
{

	@Modifying
    @Transactional
    @Query("delete from Brand b where b.brandId = ?1")
    void deleteBrandById(int brandId);
	
}
