package com.myapp.fullstack.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.fullstack.dto.PostDto;
import com.myapp.fullstack.model.Post;
import com.myapp.fullstack.repository.PostRepoistory;
@Service
public class PostService {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private PostRepoistory postRepository;
	
	public void createPost(PostDto postDto) {
		Post post = new Post();
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		User username = authService.getCurrentUser().orElseThrow(()-> new IllegalArgumentException("No user logged in"));
		post.setUsername(username.getUsername());
		post.setCreatedOn(Instant.now());
		postRepository.save(post);
	}

	@Transactional
    public List<Post> showAllPosts() {
        List<Post> posts = new ArrayList<Post>();
        posts = postRepository.findAll();
        return posts;
    }
	
	public Post readSinglePost(Long id) {
		return postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("uknown post id"));
	}
}
