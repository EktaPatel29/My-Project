package com.pcpartpicker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.ModelMap;

import com.pcpartpicker.domain.User;

@Controller
public class MainController 
{

	@RequestMapping("/computer")
	public String page()
	{
			return "product2";
		
	}
	
	@RequestMapping("/adminpage")
	
		public String index3()
		{
			return "admin";
		}

	/*@RequestMapping("/")
	  public String index() {
	    return "index" ;
	}
	*/
	@RequestMapping("/")
	  public String index() {
	    return "reportpdf" ;
	}
	
	@RequestMapping("/adminLink")	  
	  public String index1() {
	    return "adminpanel" ;
	}
	
	@RequestMapping("/customer")	  
	  public String getCustomer() {
	    return "header2" ;
	}
	
	@RequestMapping("/register")	  
	  public String getUser() {
	    return "user" ;
	}
	
	@RequestMapping("/createUser")
	public String createPage(String email, String name) 
	{
	   return "register";
	}

}
