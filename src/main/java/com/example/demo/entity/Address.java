package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String address;
	private String city;
	private String state;
	private int pincode;
	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Address(int id, String address, String city, String state, int pincode) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
}
