package com.example.demo.model;

public class RoomRequest {

	private String roomNumber;
	private int hotelCode;

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
		return "RoomRequest [roomNumber=" + roomNumber + ", hotelCode=" + hotelCode + "]";
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
