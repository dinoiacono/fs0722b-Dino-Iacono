package com.example.spring.security.auth.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<User> GetUserById(@PathVariable Long id){
        return new ResponseEntity<User>(userRepository.findById(id).get(), HttpStatus.OK);

    }

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String RemoveUserById(@PathVariable Long id){
        userRepository.deleteById(id);
        return "User deleted";

    }
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")

	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userRepository.save(user),HttpStatus.OK);
	}
	
}
