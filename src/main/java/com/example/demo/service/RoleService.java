package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Role;
import com.example.demo.model.RoleRequest;

public interface RoleService {
	public List<Role> addRoles(List<RoleRequest> request);
}
