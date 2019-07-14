package com.pcpartpicker.service;

import java.util.List;

import com.pcpartpicker.domain.AmcContractList;

public interface AmcService
{
	public List<AmcContractList> getAllAmc();
	public void  deleteAmcById(long id);
	
}