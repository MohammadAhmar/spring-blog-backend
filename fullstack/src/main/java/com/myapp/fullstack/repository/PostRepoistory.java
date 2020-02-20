package com.myapp.fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.fullstack.model.Post;

public interface PostRepoistory extends JpaRepository<Post, Long>{

}
