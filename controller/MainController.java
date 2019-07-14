package com.pcpartpicker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/")
	  public String index() {
	    return "index" ;
	}
	
	@RequestMapping("/login")
	  public String login() {
	    return "login" ;
	}
	
	@RequestMapping("/home")
	  public String home() {
	    return "index" ;
	}
	 
	@RequestMapping("/amcdisplay")
	  public String amcdisplay() {
	    return "amcinfo" ;
	}
	
	@RequestMapping("/amcneed")
	  public String amcneed() {
	    return "amcneed" ;
	}
	@RequestMapping("/report")
	  public String report() {
	    return "reportpdf" ;
	}
	
	
	
	@RequestMapping("/adminLink")	  
	  public String index1() {
	    return "adminpanel" ;
	}
	
	@RequestMapping("/customer")	  
	  public String getCustomer() {
	    return "customerpanel" ;
	}
	
	/*@RequestMapping("/register")	  
	  public String getUser() {
	    return "user" ;
	}*/
	
	@RequestMapping("/createUser")
	public String createPage(String email, String name) 
	{
	   return "register";
	}

}
