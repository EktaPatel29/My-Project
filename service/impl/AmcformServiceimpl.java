package com.pcpartpicker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpartpicker.domain.AMCContract;
import com.pcpartpicker.repository.AMCContractRepository;
import com.pcpartpicker.repository.AmcformRepository;
import com.pcpartpicker.service.AmcformService;

@Service
public class AmcformServiceimpl implements AmcformService
{

	@Autowired
	AmcformRepository AmcformRepository;

	@Override
	public List<AMCContract> getAllAmc() {
		
		return AmcformRepository.findAll();
	}

	@Override
	public void deleteAmcById(long id) {
		AmcformRepository.deleteAmcById(id);
		
	}
}