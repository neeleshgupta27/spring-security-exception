package com.neel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neel.entity.User;
import com.neel.repository.UserRepository;
import com.neel.security.CustomSecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("UserDetailsServiceImpl:: username:"+username);
		User user = userRepository.findByUsername(username);
		
		System.out.println("UserDetailsServiceImpl:: user:"+user.toString());
		if(user==null)
			throw new UsernameNotFoundException("Username or password incorrect.");
		
		
		return new CustomSecurityUser(user);
	}
}
