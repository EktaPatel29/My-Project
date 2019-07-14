package com.pcpartpicker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcpartpicker.domain.Category;
import com.pcpartpicker.repository.CategoryRepository;
import com.pcpartpicker.service.CategoryService;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	CategoryService categorySer;
	
	/*
	@RequestMapping("/createCat")
    @ResponseBody
	public String createCat( int categoryId, String categoryName) 
	{
	    Category category = null;
	    try 
	    {
	   //   category = new Category(categoryId,categoryName);
	      CategoryRepo.save(category);
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "Category succesfully created! (id = " + category.getCategoryId()+ ")";
	  }*/
	
	@RequestMapping("/enterCategory")
	  
	  public String index() {
	    return "categoryEdit" ;
	}
	
	
	@RequestMapping(value="/createCat",method=RequestMethod.POST)
  //@ResponseBody
	public @ResponseBody String create(@RequestBody Category category) 
	{
		System.out.println("Inside");
	    //user = null;
	    try 
	    {
	      //user = new User(email, name);
	      categoryRepo.save(category);
	    }
	    catch (Exception ex) {
	      return "Error creating the Category: " + ex.toString();
	    }
	    return "Category succesfully created! (id = "+category.getCategoryId()+ ")";
	  }
	
	@RequestMapping(value="/getAllCategory1",method=RequestMethod.GET)
	@ResponseBody      							//to send list of objects in JSON form
	 	public List<Category> getAllCategory()
	{
		return categorySer.getAllCategory();
	}

	@RequestMapping(value="/deleteCategory/{id}",method=RequestMethod.DELETE)
	@ResponseBody

	//public void deleteCategory(@PathVariable int id)

	public void deleteCategoryById(@PathVariable("id") int id)

	{
		categorySer.deleteCategoryById(id);
	}
	

	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	  //@ResponseBody
		public @ResponseBody String editCategory(@RequestBody Category category) 
		{
			System.out.println("Inside");
		    //user = null;
		    try 
		    {
		      //user = new User(email, name);
		      categoryRepo.save(category);
		    }
		    catch (Exception ex) {
		      return "Error creating the Category: " + ex.toString();
		    }
		    return "Category succesfully created! (id = "+category.getCategoryId()+ ")";
		  }
		
	
	
	
	/*@RequestMapping("/getCatbyName")
	  @ResponseBody
	  public String getByName(String name) {
	    String catName;
	    Category category = null;		   
	    try {
	    	Category category= CategoryRepo.findByName(name);	
		      
	    	catName= String.valueOf(category.getById());
	    }
	    catch (Exception ex) {
	      return "User not found";
	    }
	    return "The cat id  is: " + userId;
	  }
	  */
	
	
	
}

