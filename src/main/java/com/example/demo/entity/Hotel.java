package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hotel_code")
	private int id;
	@Column(name = "hotel_name")
	private String name;
	private String phone;
	@Column(name = "total_room")
	private int totalRoom;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;
	@Column(name = "star_rating")
	private int rating;
	// Add rooms
	@OneToMany(mappedBy = "hotelCode")
	private List<Room> rooms;

	@OneToMany(mappedBy = "hotelId", cascade = CascadeType.ALL)
	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getTotalRoom() {
		return totalRoom;
	}

	public void setTotalRoom(int totalRoom) {
		this.totalRoom = totalRoom;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Hotel(int id, String name, String phone, int totalRoom, Address address, int rating, List<Room> rooms) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.totalRoom = totalRoom;
		this.address = address;
		this.rating = rating;
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", phone=" + phone + ", totalRoom=" + totalRoom + ", address="
				+ address + ", rating=" + rating + ", rooms=" + rooms + ", employees=" + employees + "]";
	}

	public Hotel() {
		// TODO Auto-generated constructor stub
	}
}
