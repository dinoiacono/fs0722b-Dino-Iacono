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


import com.social.message.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/messages")
public class MessageController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MessageRepo repo;
	
	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Page<Message> messagesList(Pageable pageable) {
		Page<Message> findAll = repo.findAll(pageable);
		return findAll;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
		Message m = repo.findById(id).get();
		return new ResponseEntity<Message>(m, HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Message> saveComment(@Valid @RequestBody Message m){
		repo.save(m);
		return new ResponseEntity<Message>(m, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Message> deletecommentById(@PathVariable Long id) {
		Message m = repo.findById(id).get();
		repo.delete(m);
		return new ResponseEntity<Message>(m, HttpStatus.OK);
	}
}
