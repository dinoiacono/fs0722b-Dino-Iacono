package com.example.spring.security.auth.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.security.auth.users.User;
import com.example.spring.security.auth.users.UserRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public Page<User> userList(Pageable pageable) {
		Page<User> findAll = userRepository.findAll(pageable);
		findAll.forEach(usr -> usr.setPassword("********"));
		return findAll;

	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userRepository.findById(id).get();
		user.setPassword("********");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> updateUserById(@PathVariable Long id, @Valid @RequestBody User u){
		User user = userRepository.findById(id).get();
		user.setNome(u.getNome());
		user.setCognome(u.getCognome());
		user.setEmail(u.getEmail());
		user.setUsername(u.getUsername());
		user.setRoles(u.getRoles());
		user.setDevices(u.getDevices());
		user.setPassword(u.getPassword());
		
		userRepository.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> deleteUserById(@PathVariable Long id) {
		User user = userRepository.findById(id).get();
		userRepository.delete(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
