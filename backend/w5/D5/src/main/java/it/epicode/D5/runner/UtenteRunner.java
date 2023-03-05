package it.epicode.D5.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.epicode.D5.model.Utente;
import it.epicode.D5.service.UtenteService;

@Component
public class UtenteRunner implements ApplicationRunner{

	@Autowired UtenteService utenteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("UtenteRunner...");

//		utenteService.saveUtente("Mario", "Rossi", "m.rossi@gmail.com", "RossiMario");
//		utenteService.saveUtente("Luigi", "Verdi", "l.verdi@gmail.com", "VerdiLuigi");
//		utenteService.saveUtente("Marco", "Bianchi", "m.bianchi@gmail.com", "BianchiMarco");
//		utenteService.saveUtente("Antonio", "Violi", "a.violi@gmail.com", "VioliAntonio");
		
	}

}
