package com.example.demo.service;

import java.util.List;

import com.example.demo.model.EmployeeModel;

public interface EmployeeService {

	String add(EmployeeModel request) throws Exception;

	EmployeeModel findById(int id) throws Exception;

	List<EmployeeModel> fetchAll();

}
