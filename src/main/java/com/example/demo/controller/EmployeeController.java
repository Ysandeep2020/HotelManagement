package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/add")
	public String add(@RequestBody EmployeeModel request) throws Exception {
		return service.add(request);
	}

	@GetMapping("/{id}")
	public EmployeeModel getById(@PathVariable int id) throws Exception {
		return service.findById(id);
	}

	@GetMapping("/all")
	public List<EmployeeModel> findAll() throws Exception {
		return service.fetchAll();
	}
}
