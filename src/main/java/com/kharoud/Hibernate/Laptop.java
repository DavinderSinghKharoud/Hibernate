package com.kharoud.Hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {

	@Id
	private int Lid;
	private String Lname;
	
	@ManyToMany
	private List<Student> student = new ArrayList<Student>();
	
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public List<Student> getStudent() {
		return student;
	}
	
	public int getLid() {
		return Lid;
	}
	public void setLid(int lid) {
		Lid = lid;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	
	
}
