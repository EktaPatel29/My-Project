package com.pcpartpicker.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpartpicker.domain.Buyer;
import com.pcpartpicker.repository.BuyRepository;
import com.pcpartpicker.service.BuyerService;



@Service
public class BuyerServiceimpl implements BuyerService{
	
	@Autowired
	BuyRepository buyRepository;
	
	@Override 
	public List<Buyer> getAllBuyer()
	{
	
		return buyRepository.findAll();
	}
	@Override
	public void deleteBuyerById(long id) {
		// TODO Auto-generated method stub
		buyRepository.deleteBuyerById(id);
	}
		
	}

