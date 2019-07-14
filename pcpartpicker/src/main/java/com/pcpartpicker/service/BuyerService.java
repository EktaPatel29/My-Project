package com.pcpartpicker.service;

import java.util.List;
import com.pcpartpicker.domain.Buyer;
public interface BuyerService {
	
public List<Buyer> getAllBuyer();

public void deleteBuyerById(long id);

}
