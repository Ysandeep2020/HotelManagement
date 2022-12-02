package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RoomRequest;
import com.example.demo.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService service;

	@PostMapping("/add")
	public String add(@RequestBody RoomRequest request) throws Exception {
		return service.add(request);
	}
	
	
	@GetMapping("/{id}")
	public RoomRequest getById(@PathVariable int id) throws Exception {
		return service.findById(id);
	}
}
