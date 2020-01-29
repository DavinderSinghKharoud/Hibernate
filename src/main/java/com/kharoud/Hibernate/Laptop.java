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
	private String brand;
	private int price;
	
	@ManyToOne
	private Alien alien;
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Alien getAlien() {
		return alien;
	}
	public void setAlien(Alien alien) {
		this.alien = alien;
	}
	public int getLid() {
		return Lid;
	}
	public void setLid(int lid) {
		Lid = lid;
	}
	
	
}
