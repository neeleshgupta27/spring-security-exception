package com.neel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.neel.entity.User;
import com.neel.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	private UserRepository userRepository;
	
	@Secured({"ROLE_ADMIN"})
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@Secured("ROLE_ADMIN")
	public void performSomeAdminService() {
		System.out.println("Inside Perform some admin service..");
	}
}
