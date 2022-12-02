package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RoomType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "room_price")
	private double roomPrice;

//	@Column(name = "room_img")
//	private String RoomImage;
	@Column(name = "room_desc")
	private String roomDesc;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "room_id")
	private Room roomId;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "roomType")
//	private List<Attachment> attachment;
//	
//	public List<Attachment> getAttachment() {
//		return attachment;
//	}
//
//	public void setAttachment(List<Attachment> attachment) {
//		this.attachment = attachment;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "RoomType [id=" + id + ", roomPrice=" + roomPrice + ", roomDesc=" + roomDesc + ", roomId=" + roomId
				+ "]";
	}

	public RoomType(int id, double roomPrice, String roomDesc, Room roomId) {
		super();
		this.id = id;
		this.roomPrice = roomPrice;
		this.roomDesc = roomDesc;
		this.roomId = roomId;
	}

	public Room getRoomId() {
		return roomId;
	}

	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}

	public RoomType() {
		// TODO Auto-generated constructor stub
	}
}
