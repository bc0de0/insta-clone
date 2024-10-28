package com.careerinsta.insta_clone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerinsta.insta_clone.entity.User;
import com.careerinsta.insta_clone.service.NewUserService;

@RestController
public class AuthController {
	
	private final NewUserService userService;
	
	@Autowired
	public AuthController(NewUserService userService) {
		this.userService = userService;
	}
	
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userService.findByUserName(user.getUserName()) != null) {
            return ResponseEntity.badRequest().body("Username already taken.");
        }

        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginUser) {
        User user = userService.findByUserName(loginUser.getUserName());

        if (user != null && userService.passwordMatches(loginUser.getPasswordHash(), user.getPasswordHash())) {
            return ResponseEntity.ok("Login successful.");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials.");
        }
    }

}
