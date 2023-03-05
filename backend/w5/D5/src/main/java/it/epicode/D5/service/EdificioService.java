package it.epicode.D5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.epicode.D5.model.Edificio;
import it.epicode.D5.repository.EdificioDaoRepo;



@Service
public class EdificioService {

	@Autowired EdificioDaoRepo edificioService;
	
	public void insertEdificio(String nome, String indirizzo, String citta) {
		Edificio e = new Edificio();
		e.setNome(nome);
		e.setIndirizzo(indirizzo);
		e.setCitta(citta);
		edificioService.save(e);
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
	
	public List<Edificio> returnAllEdifici(){
		return (List<Edificio>) edificioService.findAll();
	}
	
}
