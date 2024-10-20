package com.bean;

public class AdminSignupBean {
	
	
	private String name = null;  
	private String email = null;
	private String address = null;
	private int contact = 0;
	
	public void setName(String name) {	
		this.name = name;
	}
	
	public String getName() {
		
		return this.name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}
	
	
	
	
	

}
