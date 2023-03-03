package it.epicode.D5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.epicode.D5.model.Edificio;
import it.epicode.D5.repository.EdificioDaoRepo;



@Service
public class EdificioService {

	@Autowired EdificioDaoRepo edificioService;
	
	public void insertEdificio(Edificio edificio) {
		edificioService.save(edificio);
	}
	
	public Edificio getEdificioByID(Long id) {	
		return edificioService.findById(id).get();
	}
	
	public void updateEdificio(Edificio edificio) {
		edificioService.save(edificio);
	}
	
	public void removeEdificio(Edificio edificio) {
		edificioService.delete(edificio);
	}
	
}
