package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Address;
import com.example.demo.entity.Room;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class HotelModel {

	private String name;
	private String phone;
	private Address address;
	@JsonProperty(access = Access.READ_ONLY)
	private List<Room> rooms;

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "HotelRequest [name=" + name + ", phone=" + phone + ", address=" + address + ", rooms=" + rooms + "]";
	}

	public HotelModel(String name, String phone, Address address, List<Room> rooms) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public HotelModel() {
		// TODO Auto-generated constructor stub
	}
}
