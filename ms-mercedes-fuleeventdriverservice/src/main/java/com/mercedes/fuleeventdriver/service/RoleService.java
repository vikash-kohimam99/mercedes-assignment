package com.mercedes.fuleeventdriver.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercedes.fuleeventdriver.model.Role;
import com.mercedes.fuleeventdriver.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	public Collection<Role> findAll(){
		return roleRepository.findAll();
	}

	public Optional<Role> findById(Long id){
		return roleRepository.findById(id);
	}

	public Role saveOrUpdate(Role role) {
		return roleRepository.saveAndFlush(role);
	}
}
