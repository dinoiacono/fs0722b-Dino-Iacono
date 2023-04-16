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

import com.social.chat.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/chats")
public class ChatController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ChatRepo repo;
	
	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Page<Chat> chatsList(Pageable pageable) {
		Page<Chat> findAll = repo.findAll(pageable);
		return findAll;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Chat> getChatById(@PathVariable Long id) {
		Chat c = repo.findById(id).get();
		return new ResponseEntity<Chat>(c, HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Chat> saveComment(@Valid @RequestBody Chat c){
		repo.save(c);
		return new ResponseEntity<Chat>(c, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Chat> deletecommentById(@PathVariable Long id) {
		Chat c = repo.findById(id).get();
		repo.delete(c);
		return new ResponseEntity<Chat>(c, HttpStatus.OK);
	}
}
