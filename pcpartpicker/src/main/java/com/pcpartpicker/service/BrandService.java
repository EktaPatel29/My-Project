package com.pcpartpicker.service;

import java.util.List;

import com.pcpartpicker.domain.Brand;


public interface BrandService
{
	public List<Brand> getAllBrand();
	public void  deleteBrandById(int id);
	
}
