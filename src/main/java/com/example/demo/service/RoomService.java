package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RoomModel;

public interface RoomService {

	String add(RoomModel request) throws Exception;

	RoomModel findById(int id) throws Exception;

	List<RoomModel> fetchAll();

}
