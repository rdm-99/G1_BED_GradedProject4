package com.greatlearning.employeemanagement.model;


import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class DomainUserDetails implements UserDetails {
	User user;
	public DomainUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for(Role role: roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		System.out.println("Inside the getPassword method ");
		System.out.println("Password :: "+ this.user.getPassword());
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println("User :: "+ this.user.getUsername());
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		System.out.println("User47 :: ");
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		System.out.println("User 53:: ");
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		System.out.println("User 59:: ");
		return true;
	}

	@Override
	public boolean isEnabled() {
		System.out.println("User65 :: ");
		return true;
	}

}

