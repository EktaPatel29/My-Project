package com.pcpartpicker.service;

import java.util.List;


import com.pcpartpicker.domain.Category;


public interface CategoryService
{
	public List<Category> getAllCategory(); 
	public void  deleteCategoryById(int id);
	
	
	
}
