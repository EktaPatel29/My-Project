package com.pcpartpicker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcpartpicker.domain.AmcContractList;
import com.pcpartpicker.repository.AMCContractRepository;
import com.pcpartpicker.service.AmcService;

@Controller
public class AmcController {
	@Autowired
	AMCContractRepository amcRepo;

	@Autowired
	AmcService amcSer;

	@RequestMapping("/enterAmc")

	public String index() {
		return "amclist";
	}

	@RequestMapping(value = "/createamcL", method = RequestMethod.POST)
	// @ResponseBody
	public @ResponseBody String create(@RequestBody AmcContractList amcs) {
		System.out.println("Inside");
		// user = null;
		try {
			// user = new User(email, name);
			amcRepo.save(amcs);
		} catch (Exception ex) {
			return "Error creating the amc: " + ex.toString();
		}
		return "Amc succesfully added! (id = " + amcs.getType_id() + ")";
	}

	@RequestMapping(value = "/getAllAmcType", method = RequestMethod.GET)
	@ResponseBody // to send list of objects in JSON form
	public List<AmcContractList> getAllAmc() {
		return amcSer.getAllAmc();
	}

	@RequestMapping(value = "/deleteAmc/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAmcById(@PathVariable("id") long id) {
		amcSer.deleteAmcById(id);
	}

	@RequestMapping(value = "/updateAmc", method = RequestMethod.POST)
	// @ResponseBody
	public @ResponseBody String editAmcContractList(@RequestBody AmcContractList amcs) {
		System.out.println("Inside");
		// user = null;
		try {
			// user = new User(email, name);
			amcRepo.save(amcs);
		} catch (Exception ex) {
			return "Error creating the AmcList: " + ex.toString();
		}
		return "AmcList succesfully created! (id = " + amcs.getType_id() + ")";
	}

	/*
	 * @RequestMapping("/add1")
	 * 
	 * @ResponseBody public String add(String email, String name,String
	 * itemName,Double amount) { AMCContract user = null; try { user = new
	 * AMCContract(); user.setEmail(email); user.setName(name);
	 * user.setItemName(itemName); user.setAmount(amount); amcRepo.save(user); }
	 * catch (Exception ex) { return "Error creating the user: " +
	 * ex.toString(); } return "User succesfully created! (id = " +
	 * user.getId()+ ")"; }
	 * 
	 * @RequestMapping("/del")
	 * 
	 * @ResponseBody public String delete(long id) { try { AMCContract user =
	 * new AMCContract(); user.setId(id); amcRepo.delete(user); } catch
	 * (Exception ex) { return "Error deleting the user: " + ex.toString(); }
	 * return "User succesfully deleted!"; }
	 * 
	 * 
	 * @RequestMapping("/up1")
	 * 
	 * @ResponseBody public String updateUser(long id, String email, String
	 * name) { try { AMCContract user = amcRepo.findOne(id);
	 * user.setEmail(email); user.setName(name); amcRepo.save(user); } catch
	 * (Exception ex) { return "Error updating the user: " + ex.toString(); }
	 * return "User succesfully updated!"; }
	 */
}