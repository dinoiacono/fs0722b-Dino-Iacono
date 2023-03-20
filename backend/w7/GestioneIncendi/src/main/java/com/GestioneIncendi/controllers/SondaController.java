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
import com.GestioneIncendi.models.Sonda;
import com.GestioneIncendi.services.ProcessService;
import com.GestioneIncendi.services.SondaService;

@RestController
@RequestMapping("/rilevatorefumo")
public class SondaController {
	
	@Autowired SondaService sondaService;
	@Autowired ProcessService processService;

	@GetMapping("/sonde/{id}")
	public ResponseEntity<Sonda> getSondaById(@PathVariable Long id){
		return new ResponseEntity<Sonda>(sondaService.findSondaById(id),HttpStatus.OK);	
	}
	
	@GetMapping("/sonde")
	public ResponseEntity<List<Sonda>> getAllSonda(){
		return new ResponseEntity<List<Sonda>>(sondaService.findAllSonda(),HttpStatus.OK);	
	}
	
	@PostMapping("/sonde")
	public ResponseEntity<Sonda> addSonda(@RequestBody Sonda sonda){
		return new ResponseEntity<Sonda>(sondaService.saveSonda(sonda),HttpStatus.OK);
	}
	
	@PutMapping("/sonde/{id}")
	public ResponseEntity<Sonda> updateSonda(@RequestBody Sonda sonda){
		return new ResponseEntity<Sonda>(sondaService.updateSonda(sonda), HttpStatus.OK);
	}
	
	@DeleteMapping("/sonde/{id}")
	public ResponseEntity<String> deleteSonda (@PathVariable Long id) {
		return new ResponseEntity<String>(sondaService.deleteSonda(id), HttpStatus.OK);
	}

	
	@PutMapping("/sonde/{sondaId}/{processId}")
	public ResponseEntity <List<ProcessoDispositivo>> addObserver(@PathVariable Long sondaId,@PathVariable Long processId){
		ProcessoDispositivo p = processService.findProcessById(processId);
		Sonda s = sondaService.findSondaById(sondaId);
		sondaService.addObserver(sondaId, processId);
		@SuppressWarnings("unchecked")
		List<ProcessoDispositivo> list = (List<ProcessoDispositivo>) s.getListaProcessi();
		sondaService.updateSonda(s);
		processService.updateProcess(p);
		return new ResponseEntity<List<ProcessoDispositivo>>(list,HttpStatus.OK);	
	}
	
	@PutMapping("/sonde/smokelevel/{sondaId}/{newSmokeLevel}")
	public ResponseEntity <String> increaseSmokeLevel(@PathVariable Long sondaId,@PathVariable Integer newSmokeLevel){
		sondaService.setSmokeLevel(newSmokeLevel, sondaId);
		return new ResponseEntity<String>("check", HttpStatus.OK);
	}
}
