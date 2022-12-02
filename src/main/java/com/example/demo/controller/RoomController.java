package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HotelModel;
import com.example.demo.model.RoomModel;
import com.example.demo.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService service;

	@PostMapping("/add")
	public String add(@RequestBody RoomModel request) throws Exception {
		return service.add(request);
	}
	
	
	@GetMapping("/{id}")
	public RoomModel getById(@PathVariable int id) throws Exception {
		return service.findById(id);
	}
	
	@GetMapping("/all")
	public List<RoomModel> findAll() throws Exception {
		return service.fetchAll();
	}
}
