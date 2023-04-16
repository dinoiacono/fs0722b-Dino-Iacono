package com.social.auth.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.social.post.Post;
import com.social.post.PostRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/posts")
public class PostController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PostRepository repo;
	
	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Page<Post> postList(Pageable pageable) {
		Page<Post> findAll = repo.findAll(pageable);
		return findAll;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Post> getPostById(@PathVariable Long id) {
		Post p = repo.findById(id).get();
		return new ResponseEntity<Post>(p, HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Post> savePost(@Valid @RequestBody Post p){
		repo.save(p);
		return new ResponseEntity<Post>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Post> deletePostById(@PathVariable Long id) {
		Post p = repo.findById(id).get();
		repo.delete(p);
		return new ResponseEntity<Post>(p, HttpStatus.OK);
	}
}
