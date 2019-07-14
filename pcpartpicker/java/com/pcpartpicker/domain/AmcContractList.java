
package com.pcpartpicker.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "amclist")
public class AmcContractList {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Long type_id;
	
	
//	@OneToMany(mappedBy = "contractType", cascade = CascadeType.ALL)
//    private List<User> users;

	public Long getType_id() {
		return type_id;
	}
	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}
	private String description;
	public String getDescrption() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	private int duration;
   private String name;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
