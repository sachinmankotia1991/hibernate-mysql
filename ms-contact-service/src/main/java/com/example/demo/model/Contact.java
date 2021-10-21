package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Contact")
public class Contact {

	@Id()
	private long contact_Id;
	
	private String email;
	
	private String contact_name;
	
	private long user_Id;

	public long getContactId() {
		return contact_Id;
	}

	public void setContactId(long contact_Id) {
		this.contact_Id = contact_Id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactName() {
		return contact_name;
	}

	public void setContactName(String contact_name) {
		this.contact_name = contact_name;
	}

	public long getUserId() {
		return user_Id;
	}

	public void setUserId(long user_Id) {
		this.user_Id = user_Id;
	}

}
