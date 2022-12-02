package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RoomRequest;

public interface RoomService {

	String add(RoomRequest request) throws Exception;

	RoomRequest findById(int id) throws Exception;

	List<RoomRequest> fetchAll();

}
