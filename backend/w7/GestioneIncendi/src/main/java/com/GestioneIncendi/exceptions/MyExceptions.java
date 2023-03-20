package com.GestioneIncendi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class MyExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<String> EntityExistsException(EntityExistsException e){
        return new ResponseEntity<String>("Id già esistente!", HttpStatus.NOT_FOUND);   
    }
	
	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> EntityNotFoundException(EntityNotFoundException e){
        return new ResponseEntity<String>("Id non esistente!", HttpStatus.NOT_FOUND);   
    }
}
