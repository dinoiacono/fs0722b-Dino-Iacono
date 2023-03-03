package it.epicode.D5.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.epicode.D5.service.PrenotazioneService;

@Component
public class PrenotazioneRunner implements ApplicationRunner{

	@Autowired PrenotazioneService prenotazioneService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("PrenotazioneRunner...");
	}

}
