package com.example.demo.service;

import com.example.demo.model.EmployeeRequest;

public interface EmployeeService {

	String add(EmployeeRequest request) throws Exception;

	EmployeeRequest findById(int id) throws Exception;

}
