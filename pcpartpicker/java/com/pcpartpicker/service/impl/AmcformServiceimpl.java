package com.pcpartpicker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpartpicker.repository.AmcformRepository;
import com.pcpartpicker.service.AmcformService;

@Service
public class AmcformServiceimpl implements AmcformService
{

	@Autowired
  AmcformRepository AmcformRepository;
}