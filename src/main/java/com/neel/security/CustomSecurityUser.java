package com.neel.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.neel.entity.User;

public class CustomSecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = -6806746780274513919L;

	public CustomSecurityUser() {
		
	}

	public CustomSecurityUser(User user) {
		this.setId(user.getId());
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setAuthorities(user.getAuthorities());
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}
