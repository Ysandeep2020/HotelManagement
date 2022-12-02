package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Attachment;
import com.example.demo.model.RoomTypeRequest;
import com.example.demo.service.RoomTypeService;

@RestController
@RequestMapping("/roomType")
public class RoomTypeController {
	@Autowired
	private RoomTypeService service;

	@PostMapping("/add")
	public String add(@RequestBody RoomTypeRequest request) throws Exception {
		return service.add(request);
	}

//	/**
//	 * add RoomType with Room Image
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	@PostMapping("/add")
//	public String add(@RequestPart("file") MultipartFile[] files, @RequestBody RoomTypeRequest request)
//			throws Exception {
//		return service.add(request,files);
//	}

}
