package com.pcpartpicker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpartpicker.domain.Product;
import com.pcpartpicker.repository.ProductRepository;
import com.pcpartpicker.service.ProductService;


@Service
public class ProductServiceimpl implements ProductService
{

	@Autowired
	ProductRepository productRepo;
	
	@Override
	public List<Product> getAllProduct() 
	{	

		return productRepo.findAll();    
	   
	}
	
	@Override
	public void delete(int id)
	{
		productRepo.delete(id);
	}

}
