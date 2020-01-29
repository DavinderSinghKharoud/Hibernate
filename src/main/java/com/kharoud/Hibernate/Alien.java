package com.kharoud.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity//(name = "Alient_table"), we can also add here to change table name, but also that will change entity name
@Table(name = "Alient_table")

public class Alien {
	
	@Id
	private int aid;
	@Transient
	private String aname;
	
	@Column(name="alien_color")
	private String colors;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getColors() {
		return colors;
	}
	public void setColors(String colors) {
		this.colors = colors;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", colors=" + colors + "]";
	}
	

}
