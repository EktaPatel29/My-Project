package com.pcpartpicker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpartpicker.domain.Brand;
import com.pcpartpicker.repository.BrandRepository;
import com.pcpartpicker.service.BrandService;


@Service
public class BrandServiceimpl implements BrandService
{

	@Autowired
	BrandRepository brandRepository;
	
	@Override
	public List<Brand> getAllBrand() 
	{	

		return brandRepository.findAll();    
	   
	}
	
	
	@Override
	public void deleteBrandById(int id)
	{
		brandRepository.deleteBrandById(id);
	}

}
