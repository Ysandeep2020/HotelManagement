package com.example.demo.service;

import com.example.demo.model.RoomTypeRequest;

public interface RoomTypeService {

	String add(RoomTypeRequest request) throws Exception;

	RoomTypeRequest findById(int id) throws Exception;

	// String add(RoomTypeRequest request, MultipartFile[] files) throws Exception;

}
