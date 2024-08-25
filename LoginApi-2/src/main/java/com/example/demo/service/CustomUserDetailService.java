package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.security.JwtHelper;

@Configuration
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Autowired
	private JwtHelper jwtHelper;
	
	
 
    public void validToken( String token) {
    	jwtHelper.validToken(token);
    }
    
    
	public List<User> getUsers(){

		return userRepository.findAll() ;		
	}

	public User createUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found !!"));
		return user;
	}

	
}