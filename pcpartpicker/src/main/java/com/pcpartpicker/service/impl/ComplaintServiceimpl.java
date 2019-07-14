package com.pcpartpicker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpartpicker.repository.ComplaintRepository;
import com.pcpartpicker.service.ComplaintService;

@Service
public class ComplaintServiceimpl implements ComplaintService {

	@Autowired
	ComplaintRepository ComplaintRepository;

}
