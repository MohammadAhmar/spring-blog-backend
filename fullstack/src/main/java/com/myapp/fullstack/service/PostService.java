package com.myapp.fullstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.myapp.fullstack.dto.PostDto;
import com.myapp.fullstack.model.Post;

@Service
public class PostService {
	
	@Autowired
	private AuthService authService;
	
	public void createPost(PostDto postDto) {
		Post post = new Post();
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		User username = authService.getCurrentUser().orElseThrow(( -> new IllegalArgumentException("No user logged in "));
	}
}
