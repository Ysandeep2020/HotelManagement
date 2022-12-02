package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.RoomTypeRequest;

public interface RoomTypeService {

	String add(RoomTypeRequest request) throws Exception;

	//String add(RoomTypeRequest request, MultipartFile[] files) throws Exception;

}
