package com.sandhya.touristManagementAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tourist {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String place;
	private String packages;
	private Integer budget;
	public Tourist( Integer id,String name, String place, String packages, Integer budget) {
		super();
		this.id=id;
		this.name = name;
		this.place = place;
		this.packages = packages;
		this.budget = budget;
	}
	public Tourist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	public Integer getBudget() {
		return budget;
	}
	public void setBudget(Integer budget) {
		this.budget = budget;
	}
	@Override
	public String toString() {
		return "Tourist [id=" + id + ", name=" + name + ", place=" + place + ", packages=" + packages + ", budget="
				+ budget + "]";
	}
	
	
	

}
