package com.pcpartpicker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcpartpicker.domain.Complaint;
import com.pcpartpicker.repository.ComplaintRepository;
import com.pcpartpicker.service.ComplaintService;

@Controller
public class ComplaintController {

	@Autowired
	ComplaintRepository compRepo;

	@Autowired
	ComplaintService compSer;

	@RequestMapping(value = "/createComplaint", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestBody Complaint comp) {
		System.out.println("Inside");
		// user = null;
		try {
			// user = new User(email, name);
			compRepo.save(comp);
		} catch (Exception ex) {
			return "Error creating the complaint: " + ex.toString();
		}
		return "Complaint succesfully added! (id = " + comp.getId() + ")";
	}

}
