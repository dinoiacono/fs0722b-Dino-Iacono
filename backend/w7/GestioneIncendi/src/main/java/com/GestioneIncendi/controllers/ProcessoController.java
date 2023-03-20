package com.GestioneIncendi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestioneIncendi.models.ProcessoDispositivo;
import com.GestioneIncendi.services.ProcessService;

@RestController
@RequestMapping("/processes")
public class ProcessoController {
	
	@Autowired ProcessService processService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ProcessoDispositivo> getProcessById(@PathVariable Long id){
		return new ResponseEntity<ProcessoDispositivo>(processService.findProcessById(id),HttpStatus.OK);	
	}
	
	@GetMapping
	public ResponseEntity<List<ProcessoDispositivo>> getAllProcesses(){
		return new ResponseEntity<List<ProcessoDispositivo>>(processService.findAllProcess(),HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<ProcessoDispositivo> addProcess(@RequestBody ProcessoDispositivo process){
		return new ResponseEntity<ProcessoDispositivo>(processService.saveProcess(process),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProcessoDispositivo> updateProcess(@RequestBody ProcessoDispositivo process){
		return new ResponseEntity<ProcessoDispositivo>(processService.updateProcess(process), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProcess (@PathVariable Long id) {
		return new ResponseEntity<String>(processService.deleteProcess(id), HttpStatus.OK);
	}
}
