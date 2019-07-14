package com.pcpartpicker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.pcpartpicker.repository.MainRepository;
import com.pcpartpicker.service.MainService;

public class MainServiceImpl implements MainService {

	@Autowired 
	MainRepository mainRepo;
	@Override
	public void add() {
		mainRepo.add();
		// TODO Auto-generated method stub
		
	}

}
