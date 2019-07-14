package com.pcpartpicker.service;

import java.util.List;

import com.pcpartpicker.domain.Brand;
import com.pcpartpicker.domain.Product;

public interface ProductService
{
	public List<Product> getAllProduct();

	public void delete(int id);
	
	
}
