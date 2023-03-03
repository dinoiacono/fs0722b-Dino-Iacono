package it.epicode.D5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.D5.model.Postazione;
import it.epicode.D5.model.TipoPostazione;
import it.epicode.D5.repository.PostazioneDaoRepo;


@Service
public class PostazioneService {

	@Autowired PostazioneDaoRepo postazioneService;
	@Autowired EdificioService edificioService;
	
	public void insertPostazione(String descrizione, Long id, TipoPostazione tipo) {
		Postazione pos = new Postazione();
		pos.setDescrizione(descrizione);
		pos.setDisponibilita();
		pos.setEdificio(edificioService.getEdificioByID(id));
		pos.setTipo(tipo);
		pos.setMaxUtenti();
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
}
