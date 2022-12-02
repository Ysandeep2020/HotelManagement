package com.example.demo.model;

public class RoomTypeRequest {

	private double roomPrice;
	private String roomDesc;
	private int roomId;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	@Override
	public String toString() {
		return "RoomTypeRequest [roomPrice=" + roomPrice + ", roomDesc=" + roomDesc + ", roomId=" + roomId + "]";
	}

	public RoomTypeRequest(double roomPrice, String roomDesc) {
		super();
		this.roomPrice = roomPrice;
		this.roomDesc = roomDesc;
	}

	public RoomTypeRequest() {
		// TODO Auto-generated constructor stub
	}
}
