package com.pcpartpicker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcpartpicker.domain.Brand;
import com.pcpartpicker.domain.Category;
import com.pcpartpicker.repository.BrandRepository;
import com.pcpartpicker.service.BrandService;

			
@Controller
public class BrandController 
{
	@Autowired
	BrandRepository brandRepo;
	
	
	@Autowired
	BrandService brandSer;
	
	
	
	/*@RequestMapping("/createBrand")
    @ResponseBody
	public String createBrand( int brandId, String brandName,long categoryId) 
	{
	    Brand brand = null;
	    try 
	    {
	    //  brand = new Brand(brandId,brandName);
	     Category category= categoryRepo.findOne(categoryId);
	  	//brand.setCategory(category);
	      BrandRepo.save(brand);
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "Brand succesfully created! (id = " + brand.getBrandId()+ ")";
	  }
	*/
	
	@RequestMapping("/enterBrand")
	  
	  public String index() {
	    return "brandEdit";
	    		
	}
	
	
	@RequestMapping(value="/createBrand",method=RequestMethod.POST)
//@ResponseBody
	public @ResponseBody String create(@RequestBody Brand brand) 
	{
		System.out.println("Inside");
	    //user = null;
	    try 
	    {
	      //user = new User(email, name);
	    brandRepo.save(brand);
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created! (id = "+brand.getBrandId()+ ")";
	  }
	
	
	@RequestMapping(value="/getAllBrand1",method=RequestMethod.GET)
	@ResponseBody      							//to send list of objects in JSON form
	 	public List<Brand> getAllBrand()
	{
		return brandSer.getAllBrand();
	}
	
	@RequestMapping(value="/deleteBrand/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteBrandById(@PathVariable("id") int id)
	{
		brandSer.deleteBrandById(id);
	}
	
	@RequestMapping(value="/updateBrand",method=RequestMethod.POST)
	  //@ResponseBody
		public @ResponseBody String editBrand(@RequestBody Brand brand) 
		{
			System.out.println("Inside");
		    //user = null;
		    try 
		    {
		      //user = new User(email, name);
		      brandRepo.save(brand);
		    }
		    catch (Exception ex) {
		      return "Error creating the Brand: " + ex.toString();
		    }
		    return "Brand succesfully created! (id = "+brand.getBrandId()+ ")";
		  }
	
	
	
}

