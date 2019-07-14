package com.pcpartpicker.service;

import java.util.List;

import com.pcpartpicker.domain.AMCContract;

public interface AmcformService
{
	public List<AMCContract> getAllAmc();
	public void  deleteAmcById(long id);
	
}