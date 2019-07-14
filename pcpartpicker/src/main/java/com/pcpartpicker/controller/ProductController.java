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
import com.pcpartpicker.domain.Product;
import com.pcpartpicker.repository.BrandRepository;
import com.pcpartpicker.repository.ProductRepository;
import com.pcpartpicker.service.ProductService;


@Controller
public class ProductController
{
	@Autowired
	ProductRepository productRepo;
	
	
	@Autowired
	ProductService productSer;
	
	@Autowired
	BrandRepository brandRepo;
	
	
	@RequestMapping("/enterProduct")
	  
	  public String index() {
	    return "product1" ;
	}
	
	
	@RequestMapping(value="/createProduct",method=RequestMethod.POST)
//@ResponseBody
	public @ResponseBody String create(@RequestBody Product product) 
	{
		System.out.println("Inside");
	    //user = null;
	    try 
	    {
	      //user = new User(email, name);
	      productRepo.save(product);
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created! (id = "+product.getProductId()+ ")";
	  }
	
	
	@RequestMapping(value="/getAllProduct1",method=RequestMethod.GET)
	@ResponseBody      							//to send list of objects in JSON form
	 	public List<Product> getAllProduct()
	{
		return productSer.getAllProduct();
	}
	
	
	@RequestMapping(value="/deleteProduct/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteProductById(@PathVariable("id") int id)
	{
		productSer.delete(id);
	}
	
}
