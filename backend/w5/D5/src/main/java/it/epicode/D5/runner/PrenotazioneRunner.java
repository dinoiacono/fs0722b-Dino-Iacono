package it.epicode.D5.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.epicode.D5.model.*;
import it.epicode.D5.service.*;

@Component
public class PrenotazioneRunner implements ApplicationRunner{

	@Autowired PrenotazioneService prenotazioneService;
	@Autowired UtenteService utenteService;
	@Autowired PostazioneService postazioneService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("PrenotazioneRunner...");
		
		Postazione postazione = postazioneService.getPostazioneByID(1l);
		Utente utente = utenteService.getUtenteByID(2l);
		
//		prenotazioneService.salvaPrenotazione(utente, postazione, "2023-03-10", 10);		
//		prenotazioneService.salvaPrenotazione(utente, postazione, "2023-03-11", 50);
	}

}
