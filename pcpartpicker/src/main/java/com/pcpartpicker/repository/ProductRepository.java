package com.pcpartpicker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcpartpicker.domain.Product;
//import com.pcpartpicker.domain.Category;


public interface ProductRepository extends JpaRepository<Product,Integer>
{
	
}
