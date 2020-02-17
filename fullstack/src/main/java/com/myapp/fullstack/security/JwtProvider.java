package com.myapp.fullstack.security;

import com.myapp.fullstack.model.User;

@Service
public class JwtProvider {
	
	private Key key
	
	@PostConstruct
	public void init() {
		key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	}
	public String generateToken(Authentication authentication) {
		User principal = (User) authentication.getPrincipal();
		return Jwts.builder()
				.setSubject(principal.getUserName())
				.signWith(Keys.secretKeyFor(SignatueAlgorithm.HS512))
				.compact();
	}
}
