package com.pcpartpicker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pcpartpicker.repository.UserRepository;
import com.pcpartpicker.service.UserService;

@Service
public class UserServiceimpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public String getHashPassword(String password) {
		  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		  String hashedPassword = passwordEncoder.encode(password);

		  System.out.println(hashedPassword);
		  return hashedPassword;
		 }

	
	

}
