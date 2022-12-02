package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RoomModel;
import com.example.demo.model.RoomTypeModel;
import com.example.demo.service.RoomTypeService;

@RestController
@RequestMapping("/roomType")
public class RoomTypeController {
	@Autowired
	private RoomTypeService service;

	@PostMapping("/add")
	public String add(@RequestBody RoomTypeModel request) throws Exception {
		return service.add(request);
	}

	@GetMapping("/{id}")
	public RoomTypeModel getById(@PathVariable int id) throws Exception {
		return service.findById(id);
	}
	
	
	@GetMapping("/all")
	public List<RoomTypeModel> findAll() throws Exception {
		return service.fetchAll();
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
