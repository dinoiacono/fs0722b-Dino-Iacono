package it.epicode.D5.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.epicode.D5.service.PostazioneService;

@Component
public class PostazioneRunner implements ApplicationRunner{

	@Autowired PostazioneService postazioneService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("PostazioneRunner...");
	}

}
