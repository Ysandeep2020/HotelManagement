package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Hotel;
import com.example.demo.model.EmployeeRequest;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.HotelRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	@Autowired
	private HotelRepository hotelRepo;

	@Autowired
	private RoleService roleService;

	@Override
	public String add(EmployeeRequest request) throws Exception {
		Employee emp = new Employee();
		BeanUtils.copyProperties(request, emp);
		Hotel hotel = hotelRepo.findById(request.getHotelId())
				.orElseThrow(() -> new Exception("Not Found Any Hotel with this id:" + request.getHotelId()));
		emp.setHotelId(hotel);
		// add Roles
		emp.setRoles(roleService.addRoles(request.getRoles()));
		repo.save(emp);
		return "Employee Added...";
	}

}
