package com.kharoud.Hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class AlienName {
	
	private String Fname;
	private String Lname;
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		this.Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		this.Lname = lname;
	}
	
	

}
