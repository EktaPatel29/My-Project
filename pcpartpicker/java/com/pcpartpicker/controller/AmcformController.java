package com.pcpartpicker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcpartpicker.domain.AMCContract;
import com.pcpartpicker.repository.AmcformRepository;
import com.pcpartpicker.service.AmcformService;

@Controller
public class AmcformController {

	@Autowired
	AmcformRepository amcRepo;

	@Autowired
	AmcformService amcSer;

	@RequestMapping("/enterAmcInfo")

	public String amcintro() {
		return "amcinfo";
	}

	@RequestMapping("/form")
	public String page() {
		return "amcform";

	}

	@RequestMapping(value = "/createamcF", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestBody AMCContract amcs) {
		System.out.println("Inside");
		// user = null;
		try {
			// user = new User(email, name);
			amcRepo.save(amcs);
		} catch (Exception ex) {
			return "Error creating the amc: " + ex.toString();
		}
		return "Amc succesfully added! (id = " + amcs.getId() + ")";
	}

}
