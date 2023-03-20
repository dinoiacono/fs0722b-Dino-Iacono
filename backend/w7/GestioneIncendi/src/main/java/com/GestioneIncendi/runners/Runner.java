package com.GestioneIncendi.runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.GestioneIncendi.models.DispositivoFactory;
import com.GestioneIncendi.models.ProcessoDispositivo;
import com.GestioneIncendi.models.TipoDispositivo;
import com.GestioneIncendi.models.Sonda;
import com.GestioneIncendi.services.ProcessService;
import com.GestioneIncendi.services.SondaService;

@Component
public class Runner implements ApplicationRunner {
	
	@Autowired SondaService sondaServ;
	@Autowired ProcessService processServ;

	@Override
	public void run(ApplicationArguments args) throws Exception {

//		Sonda sonda = (Sonda) DispositivoFactory.createDevice(TipoDispositivo.SONDA);
//		sonda.setLatitude(3);
//		sonda.setLongitude(8);
//		sondaServ.saveSonda(sonda);
//		
//		Sonda sonda1 = (Sonda) DispositivoFactory.createDevice(TipoDispositivo.SONDA);
//		sonda1.setLatitude(45);
//		sonda1.setLongitude(20);
//		sondaServ.saveSonda(sonda1);
//		
//		Sonda sonda2 = (Sonda) DispositivoFactory.createDevice(TipoDispositivo.SONDA);
//		sonda2.setLatitude(80);
//		sonda2.setLongitude(42);
//		sondaServ.saveSonda(sonda2);
//		
//		ProcessoDispositivo d = new ProcessoDispositivo();
//		processServ.saveProcess(d);
//		
//		ProcessoDispositivo d1 = new ProcessoDispositivo();
//		processServ.saveProcess(d1);
//		
//		ProcessoDispositivo d2 = new ProcessoDispositivo();
//		processServ.saveProcess(d2);		
//		
//		sondaServ.addObserver(1L, 1L);
//		
//		sondaServ.setSmokeLevel(5, 1L);
		
	}

}
