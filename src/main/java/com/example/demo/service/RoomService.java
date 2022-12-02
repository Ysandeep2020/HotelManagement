package com.example.demo.service;

import com.example.demo.model.RoomRequest;

public interface RoomService {

	String add(RoomRequest request) throws Exception;

	RoomRequest findById(int id) throws Exception;

}
