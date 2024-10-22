package com.careerinsta.insta_clone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.careerinsta.insta_clone.entity.User;
import com.careerinsta.insta_clone.repository.UserRepository;

@Service
public class NewUserService {

	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public NewUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
    public User registerUser(User user) {
        // Hash the password before saving
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return userRepository.save(user);
    }
    
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

	public boolean passwordMatches(String inputPassword, String savedPassword) {
		return passwordEncoder.matches(inputPassword, savedPassword);
	}
}
