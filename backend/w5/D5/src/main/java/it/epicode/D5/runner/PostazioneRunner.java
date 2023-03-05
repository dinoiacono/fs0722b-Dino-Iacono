package it.epicode.D5.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.epicode.D5.model.*;
import it.epicode.D5.service.*;

@Component
public class PostazioneRunner implements ApplicationRunner{

	@Autowired PostazioneService postazioneService;
	@Autowired EdificioService edificioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("PostazioneRunner...");

//		postazioneService.insertPostazione(edificioService.getEdificioByID(1l), "Prova", TipoPostazione.OPENSPACE);
//		postazioneService.insertPostazione(edificioService.getEdificioByID(1l), "Prova 2", TipoPostazione.PRIVATO);
//		postazioneService.insertPostazione(edificioService.getEdificioByID(2l),"Prova 3", TipoPostazione.OPENSPACE);
//		postazioneService.insertPostazione(edificioService.getEdificioByID(3l), "Prova 4", TipoPostazione.SALARIUNIONI);
		
		List<Postazione> listaP = postazioneService.getAllPostazioneByTipo(TipoPostazione.PRIVATO);
		listaP.forEach(p -> p.stampaPostazione());
		
//		List<Postazione> listaPosti = postazioneService.getAllPostazioneByCity("Roma");
//		listaPosti.forEach(p -> p.stampaPostazione());


	}

}
