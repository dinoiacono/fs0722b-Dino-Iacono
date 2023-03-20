package com.GestioneIncendi.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestioneIncendi.models.ProcessoDispositivo;
import com.GestioneIncendi.models.Sonda;
import com.GestioneIncendi.repositories.SondaRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class SondaService {
	
	@Autowired SondaRepository sondaRepo;
	@Autowired ProcessService processService;
	
	public Sonda saveSonda(Sonda s) {
		return sondaRepo.save(s);
	}
	
	public Sonda findSondaById(Long id) {
		if(!sondaRepo.existsById(id)) {
			throw new EntityExistsException("Error! Id not found!");
		}
		return sondaRepo.findById(id).get();
	}
	
	public List<Sonda> findAllSonda(){
		return sondaRepo.findAll();
	}
	
	public Sonda updateSonda(Sonda s) {
		if(!sondaRepo.existsById(s.getId())) {
			throw new EntityExistsException("Error! Id not found!");
		}
		return sondaRepo.save(s);
	}
	
	public String deleteSonda (Long id) {
		if(!sondaRepo.existsById(id)) {
			throw new EntityExistsException("Error! Id not found!");
		}
		sondaRepo.deleteById(id);
		return "Sonda cancellata"; 
	}

	public Set<ProcessoDispositivo> addObserver( Long sondaId,Long processId) {
		Sonda observable = findSondaById(sondaId);
		ProcessoDispositivo observer = processService.findProcessById(processId);
		observer.setSmokeLevel(observable.getSmokeLevel());
		processService.updateProcess(observer);
		observable.getListaProcessi().add(observer);
        updateSonda(observable);
        return observable.getListaProcessi();
    }
	
	 public void setSmokeLevel(Integer newSmokeLevel,Long sondaId) {
		 Sonda s = findSondaById(sondaId);
		 s.setSmokeLevel(newSmokeLevel);
		 updateSonda(s);
	        for (ProcessoDispositivo o : s.getListaProcessi()) {
	            o.update(newSmokeLevel);
	            processService.updateProcess(o);
	            if(o.update(newSmokeLevel)) {
	             System.out.println("Sonda id " + s.getId() + " rilevato livello di fumo " + s.getSmokeLevel() + "!! Inviare vigili del fuoco a latitudine " + s.getLatitude() + ", longitudine " + s.getLongitude()+ " !! - Allarme inviato da processo id " + o.getId() ); 
	            }      
	        }
	    }
}
