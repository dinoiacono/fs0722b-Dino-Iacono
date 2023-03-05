package it.epicode.D5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.D5.model.Edificio;
import it.epicode.D5.model.Postazione;
import it.epicode.D5.model.TipoPostazione;
import it.epicode.D5.repository.PostazioneDaoRepo;


@Service
public class PostazioneService {

	@Autowired PostazioneDaoRepo postazioneService;
	@Autowired EdificioService edificioService;
	
	public void insertPostazione(Edificio ed, String des, TipoPostazione t) {
		Postazione pos = new Postazione();
		pos.setDisponibilita(true);
		pos.setEdificio(ed);
		pos.setDescrizione(des);
		pos.setTipo(t);
		
		switch (pos.getTipo()) {
		case OPENSPACE:
			pos.setMaxUtenti(50);
			break;
		case PRIVATO:
			pos.setMaxUtenti(10);
			break;
		case SALARIUNIONI:
			pos.setMaxUtenti(70);
			break;
		default: pos.setMaxUtenti(1);
			break;
		}
		postazioneService.save(pos);
		
	}
	
	public Postazione getPostazioneByID(Long id) {	
		return postazioneService.findById(id).get();
	}
	
	public void updatePostazione(Postazione pos) {
		postazioneService.save(pos);
	}
	
	public void removePostazione(Postazione pos) {
		postazioneService.delete(pos);
	}
	
	public List<Postazione> getAllPostazioneByTipo(TipoPostazione tipo) {
		return (List<Postazione>) postazioneService.findByTipo(tipo);
	}
	
	public List<Postazione> getAllPostazioneByCity(String citta) {
		return postazioneService.findByEdificioCitta(citta);
	}

}
