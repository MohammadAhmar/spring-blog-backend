package com.myapp.fullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.fullstack.dto.LoginRequest;
import com.myapp.fullstack.dto.RegisterRequest;
import com.myapp.fullstack.model.User;
import com.myapp.fullstack.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
		@PostMapping("/signup")
		public ResponseEntity<User> signup(@RequestBody RegisterRequest registerRequest) {
			authService.signup(registerRequest);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		@PostMapping("/login")
		public String login(@RequestBody LoginRequest loginRequest) {
			return authService.login(loginRequest);
		}
}
