package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RoomTypeModel;

public interface RoomTypeService {

	String add(RoomTypeModel request) throws Exception;

	RoomTypeModel findById(int id) throws Exception;

	List<RoomTypeModel> fetchAll();

	// String add(RoomTypeRequest request, MultipartFile[] files) throws Exception;

}
