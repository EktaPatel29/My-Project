
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
	


	public Long getType_id() {
		return type_id;
	}
	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}
	
	
	private String support;
	public String getSupport() {
		return support;
	}
	public void setSupport(String support) {
		this.support = support;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getAntivirus() {
		return antivirus;
	}
	public void setAntivirus(String antivirus) {
		this.antivirus = antivirus;
	}
	public String getVisit() {
		return visit;
	}
	public void setVisit(String visit) {
		this.visit = visit;
	}
	public String getSpare() {
		return spare;
	}
	public void setSpare(String spare) {
		this.spare = spare;
	}
	public String getCharged() {
		return charged;
	}
	public void setCharged(String charged) {
		this.charged = charged;
	}
	public String getChargel() {
		return chargel;
	}
	public void setChargel(String chargel) {
		this.chargel = chargel;
	}
	public String getBackup() {
		return backup;
	}
	public void setBackup(String backup) {
		this.backup = backup;
	}


	private String network;
	private String antivirus;
	private String visit;
	private String spare;
	private String charged;
	private String chargel;
	private String backup;
	
	private String description;
	public String getDescrption() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	private String duration;
   private String name;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
