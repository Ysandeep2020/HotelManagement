package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.model.RoleRequest;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepo;

	public List<Role> addRoles(List<RoleRequest> request) {
		List<Role> roles = new ArrayList<Role>();
		request.stream().forEach(role -> {
			Role tempRole = new Role();
			tempRole.setRole(role.getRole());
			roleRepo.save(tempRole);
			roles.add(tempRole);
		});
		return roles;
	}
}
