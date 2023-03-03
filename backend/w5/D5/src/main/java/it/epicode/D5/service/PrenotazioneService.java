package it.epicode.D5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.D5.model.Prenotazione;
import it.epicode.D5.repository.PrenotazioneDaoRepo;

@Service
public class PrenotazioneService {

	@Autowired PrenotazioneDaoRepo prenotazioneService;

	public void insertPrenotazione(Prenotazione p) {
		prenotazioneService.save(p);
	}
	
	public Prenotazione getPrenotazioneByID(Long id) {	
		return prenotazioneService.findById(id).get();
	}
	
	public void updatePrenotazione(Prenotazione p) {
		prenotazioneService.save(p);
	}
	
	public void removePrenotazione(Prenotazione p) {
		prenotazioneService.delete(p);
	}
}
