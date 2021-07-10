package com.SpringBatchDemo.phase1WithH2.model;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Person {
	@Id
	private long ID;
	private String last_name;
	private String first_name;
	private String phone;
	private String email;
	private String title;
	private String designation;
	
	public Person() {
	
	}
	public Person(long ID , String last_name, String first_name, String phone, String email, String title, String designation) {
		super();
		this.ID = ID;
		this.last_name = last_name;
		this.first_name = first_name;
		this.phone = phone;
		this.email = email;
		this.title = title;
		this.designation = designation;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
}
