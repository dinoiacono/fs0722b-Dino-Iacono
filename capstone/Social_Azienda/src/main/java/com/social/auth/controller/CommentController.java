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

import com.social.comment.Comment;
import com.social.comment.CommentRepo;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/comments")
public class CommentController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CommentRepo repo;
	
	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Page<Comment> commentsList(Pageable pageable) {
		Page<Comment> findAll = repo.findAll(pageable);
		return findAll;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
		Comment c = repo.findById(id).get();
		return new ResponseEntity<Comment>(c, HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Comment> saveComment(@Valid @RequestBody Comment c){
		repo.save(c);
		return new ResponseEntity<Comment>(c, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Comment> deletecommentById(@PathVariable Long id) {
		Comment c = repo.findById(id).get();
		repo.delete(c);
		return new ResponseEntity<Comment>(c, HttpStatus.OK);
	}
}
