package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeRequest;
import com.example.demo.model.HotelRequest;
import com.example.demo.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;

	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody HotelRequest hotel) {
		return ResponseEntity.ok().body(hotelService.add(hotel));
	}

	@GetMapping("/{id}")
	public HotelRequest getById(@PathVariable int id) throws Exception {
		return hotelService.findById(id);
	}
	
	@GetMapping("/all")
	public List<HotelRequest> findAll() throws Exception {
		return hotelService.fetchAll();
	}
}
