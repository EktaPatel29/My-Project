package com.pcpartpicker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpartpicker.domain.Category;
import com.pcpartpicker.repository.CategoryRepository;
import com.pcpartpicker.service.CategoryService;


@Service
public class CategoryServiceimpl implements CategoryService
{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategory() 
	{
		return categoryRepository.findAll();	   
	}
	
	@Override
	public void deleteCategoryById(int id)
	{
		categoryRepository.deleteCategoryById(id);
	}
	
	
	
	
	

}
