package com.pcpartpicker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcpartpicker.domain.Buyer;
import com.pcpartpicker.repository.BuyRepository;
import com.pcpartpicker.service.BuyerService;


@Controller
public class BuyController {
	
	@Autowired
	BuyRepository buyRepo;
	
	@Autowired
	BuyerService buyerSer;
	
	
	@RequestMapping("/enterBuyer")
	  
	  public String index() {
	    return "Buyer" ;
	}
	
	
	@RequestMapping(value="/createBuy",method=RequestMethod.POST)
	public @ResponseBody String create(@RequestBody Buyer buy) 
	{
		
		
		System.out.println("Inside");
	    //user = null;
	    try 
	    {
	      //user = new User(email, name);
	      buyRepo.save(buy);
	    }
	    catch (Exception ex) { 
	      return "Error creating the buyer: " + ex.toString();
	    }
	    return "Buyer succesfully created! (id = "+buy.getBuyerId()+ ")";
	  }
	
	
	
	@RequestMapping(value="/getAllBuyer",method=RequestMethod.GET)
	@ResponseBody      							//to send list of objects in JSON form
	 	public List<Buyer> getAllBuyer()
	{
		return buyerSer.getAllBuyer();
	}
	
	@RequestMapping(value="/deleteBuyer/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteCategoryById(@PathVariable("id") long id)

	{
		buyerSer.deleteBuyerById(id);
	}
	

	@RequestMapping(value="/updateBuyer",method=RequestMethod.POST)
	  //@ResponseBody
		public @ResponseBody String editBuyer(@RequestBody Buyer buy) 
		{
			System.out.println("Inside");
		    //user = null;
		    try 
		    {
		      //user = new User(email, name);
		      buyRepo.save(buy);
		    }
		    catch (Exception ex) {
		      return "Error creating the buyer: " + ex.toString();
		    }
		    return "Category succesfully created! (id = "+buy.getBuyerId()+ ")";
		}
	
	
}	
	
