package com.greatlearning.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.greatlearning.model.Role;
import com.greatlearning.model.User;
import com.greatlearning.repository.UserRepository;

@Configuration
public class BootstrapData {
	private final UserRepository userRepository;
	
	public BootstrapData(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertAppData(ApplicationReadyEvent event) {
//		User Rohan = new User("Rohan","welcome","qwertyromo@gmail.com");
//		User John = new User("John","welcome","John@gmail.com");
//		
//		Role userRole = new Role("USER");
//		Role adminRole = new Role("ADMIN");
		
//		John.add(userRole);
//		Rohan.addRole(adminRole);
//		Rohan.addRole(userRole);
		
//		this.userRepository.save(John);
//		this.userRepository.save(Rohan);
	}
}
