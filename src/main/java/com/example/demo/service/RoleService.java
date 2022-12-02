package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Role;
import com.example.demo.model.RoleModel;

public interface RoleService {
	public List<Role> addRoles(List<RoleModel> request);
}
