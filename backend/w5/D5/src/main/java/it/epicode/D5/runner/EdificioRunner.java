package it.epicode.D5.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.epicode.D5.service.EdificioService;



@Component
public class EdificioRunner implements ApplicationRunner {
	
	@Autowired EdificioService edificioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("EdificioRunner...");
		
//		edificioService.insertEdificio("Prova", "Via Roma 1", "Roma");
//		edificioService.insertEdificio("Milano 2", "Via milano 1", "Milano");
//		edificioService.insertEdificio("Milano 3", "Via milano 3", "Milano");
//		edificioService.insertEdificio("Firenze 10", "Via firenze 3", "Firenze");

	}

}
