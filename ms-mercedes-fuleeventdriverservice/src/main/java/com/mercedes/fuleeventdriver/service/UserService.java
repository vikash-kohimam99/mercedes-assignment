package com.mercedes.fuleeventdriver.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercedes.fuleeventdriver.model.User;
import com.mercedes.fuleeventdriver.repository.UserReposiitory;

@Service
public class UserService {
	
	@Autowired
	private UserReposiitory userRepo;
	
	public Collection<User> findAll(){
		return userRepo.findAll();
	}

	public Optional<User> findById(Long id){
		return userRepo.findById(id);
	}
	
	public User saveOrUpdate(User user) {
		return userRepo.saveAndFlush(user);
	}
}
