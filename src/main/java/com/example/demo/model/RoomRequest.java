package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.RoomType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class RoomRequest {

	private String roomNumber;
	private int hotelCode;
	@JsonProperty(access = Access.READ_ONLY)
	private List<RoomType> roomType;

	public List<RoomType> getRoomType() {
		return roomType;
	}

	public void setRoomType(List<RoomType> roomType) {
		this.roomType = roomType;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getHotelCode() {
		return hotelCode;
	}

	public void setHotelCode(int hotelCode) {
		this.hotelCode = hotelCode;
	}

	@Override
	public String toString() {
		return "RoomRequest [roomNumber=" + roomNumber + ", hotelCode=" + hotelCode + ", roomType=" + roomType + "]";
	}

	public RoomRequest(String roomNumber, int hotelCode) {
		super();
		this.roomNumber = roomNumber;
		this.hotelCode = hotelCode;
	}

	public RoomRequest() {
		// TODO Auto-generated constructor stub
	}
}
