package com.pcpartpicker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpartpicker.domain.AmcContractList;
import com.pcpartpicker.repository.AMCContractRepository;
import com.pcpartpicker.service.AmcService;

@Service
public class AmcServiceimpl implements AmcService
{

	@Autowired
  AMCContractRepository AmcContractRepository;
	
	@Override
	public List<AmcContractList> getAllAmc()
	{
		
		return AmcContractRepository.findAll();
	    
	   
	}
	
	@Override
	public void deleteAmcById(long id)
	{
		AmcContractRepository.deleteAmcById(id);
	}
	

}

