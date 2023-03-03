package it.epicode.D5.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.epicode.D5.service.UtenteService;

@Component
public class UtenteRunner implements ApplicationRunner{

	@Autowired UtenteService utenteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("UtenteRunner...");
		//utenteService.saveUtente("tizio", "caio", "tizio.caio@gmail.com", "caio-tizio");
	}

}
