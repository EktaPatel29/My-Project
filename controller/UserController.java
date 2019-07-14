
package com.pcpartpicker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcpartpicker.domain.User;
import com.pcpartpicker.domain.UserRole;
import com.pcpartpicker.repository.UserRepository;
import com.pcpartpicker.repository.UserRolesRepository;
import com.pcpartpicker.service.UserService;



@Controller
public class UserController 
{		
		/*@RequestMapping(value = "/PostFormData", method = RequestMethod.POST)
		public @ResponseBody User PostService(@RequestBody User user) 
		{
			return user;
		}
		
		@RequestMapping(value = "/PostFormDataByParam", method = RequestMethod.POST)
		public @ResponseBody User PostFormDataByParam(HttpServletRequest request) 
		{
			
			User user = new User();
			user.setUserid(Long.parseLong(request.getParameter("userId")));
			user.setUserName(request.getParameter("userName"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setEnabled(Integer.parseInt(request.getParameter("enabled")));
			//user.setName(request.getParameter("location"));
			//user.setName(request.getParameter("phone"));
			return user;
		}*/
		
		/*@RequestMapping("/AddUser")
		String myUser()
		{
			return "user";
		}*/

	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userSer;
	@Autowired
	UserRolesRepository userRoleRepo;
	
	@RequestMapping("/signUp")
	  
	  public String index() {
	    return "user" ;
	}
	
	@RequestMapping("/admin")
	  
	  public String index1() {
	    return "admin" ;
	}
	
	
	@RequestMapping(value="/createUser",method=RequestMethod.POST)
    //@ResponseBody
	public @ResponseBody String create(@RequestBody User user) 
	{
		System.out.println("Inside");
	    //user = null;
	    try 
	    {
	      //user = new User(email, name);
	    	String password=user.getPassword();
	    	String bcryptedpassword=userSer.getHashPassword(password);
	    	user.setPassword(bcryptedpassword);
	    	
	    	User u=userRepo.save(user);
	      
	    Long UserId= u.getUserid();
		UserRole urole= new UserRole();
		urole.setRole("ROLE_USER");
		urole.setUserid(UserId);
		userRoleRepo.save(urole);
		
	      
	      
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created! (id = " + user.getUserid()+ ")";
	  }
	
	
}
