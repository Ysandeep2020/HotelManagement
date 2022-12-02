package com.example.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Hotel;
import com.example.demo.entity.Role;
import com.example.demo.model.EmployeeRequest;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.RoleRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	@Autowired
	private HotelRepository hotelRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public String add(EmployeeRequest request) throws Exception {
		Employee emp = new Employee();
		BeanUtils.copyProperties(request, emp);
		Hotel hotel = hotelRepo.findById(request.getHotelId())
				.orElseThrow(() -> new Exception("Not Found Any Hotel with this id:" + request.getHotelId()));
		emp.setHotelId(hotel);
		// Add role
		addRole(request.getRoles());
		repo.save(emp);
		return "Employee Added...";
	}

	private void addRole(List<Role> roles) {
		roles.stream().forEach(role -> {
			roleRepo.save(role);
		});
	}

	@Override
	public EmployeeRequest findById(int id) throws Exception {
		EmployeeRequest model = new EmployeeRequest();
		Employee emp = repo.findById(id).orElseThrow(() -> new Exception("Employee Not found with :" + id));
		BeanUtils.copyProperties(emp, model);
		model.setHotelId(emp.getHotelId().getId());
		return model;
	}

}
