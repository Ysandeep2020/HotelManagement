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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "room_id")
	private int id;
	@Column(name = "room_number")
	private String roomNumber;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "hotel_code")
	private Hotel hotelCode;

	@OneToMany(mappedBy = "roomId")
	private List<RoomType> roomType;

	
	
	
	public List<RoomType> getRoomType() {
		return roomType;
	}

	public void setRoomType(List<RoomType> roomType) {
		this.roomType = roomType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Hotel getHotelCode() {
		return hotelCode;
	}

	public void setHotelCode(Hotel hotelCode) {
		this.hotelCode = hotelCode;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNumber=" + roomNumber + ", hotelCode=" + hotelCode + ", roomType=" + roomType
				+ "]";
	}

	public Room(int id, String roomNumber, Hotel hotelCode) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.hotelCode = hotelCode;
	}

	public Room() {
		// TODO Auto-generated constructor stub
	}
}
