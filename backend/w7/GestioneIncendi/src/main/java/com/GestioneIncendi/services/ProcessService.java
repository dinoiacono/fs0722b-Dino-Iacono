package com.GestioneIncendi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestioneIncendi.models.ProcessoDispositivo;
import com.GestioneIncendi.repositories.ProcessoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;

@Service
public class ProcessService {

	@Autowired ProcessoRepository processoRepo;
	
	public ProcessoDispositivo saveProcess(ProcessoDispositivo p) {
		return processoRepo.save(p);
	}

	public ProcessoDispositivo findProcessById(Long id) {
		if(!processoRepo.existsById(id)) {
			throw new EntityExistsException("Error! Id not found!");
		}
		return processoRepo.findById(id).get();
	}
	
	public List<ProcessoDispositivo> findAllProcess(){
		return processoRepo.findAll();
	}
	
	public ProcessoDispositivo updateProcess(ProcessoDispositivo p) {
		if(!processoRepo.existsById(p.getId())) {
			throw new EntityExistsException("Error! Id not found!");
		}
		return processoRepo.save(p);
	}
	
	public String deleteProcess (Long id) {
		if(!processoRepo.existsById(id)) {
			throw new EntityExistsException("Error! Id not found!");
		}
		processoRepo.deleteById(id);
		return "Process deleted";
	}
	

}
