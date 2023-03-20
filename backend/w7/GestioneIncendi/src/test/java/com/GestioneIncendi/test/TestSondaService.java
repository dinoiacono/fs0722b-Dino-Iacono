package com.GestioneIncendi.test;

import static org.junit.Assert.*;
import java.util.Set;
import org.junit.BeforeClass;
import org.junit.Test;

import com.GestioneIncendi.models.ProcessoDispositivo;
import com.GestioneIncendi.models.TipoDispositivo;
import com.GestioneIncendi.models.Sonda;

public class TestSondaService {
	static Sonda s;
	static ProcessoDispositivo d;
	
	@BeforeClass
	public static void creaSondaEProcess() {
		s = new Sonda(1L, TipoDispositivo.SONDA, 15, 10, 0);
		d = new ProcessoDispositivo(1L, null);
	}

	@Test
	public void testSetSmokeLevel() {
			 Set<ProcessoDispositivo> x = s.getListaProcessi();
			 x.add(d);
			// check list size
			 assertEquals(1,x.size());
			 s.setSmokeLevel(5);
		        for (ProcessoDispositivo o : x) {
		        	o.setSmokeLevel(s.getSmokeLevel());
		        	// check smoke level
		        	assertEquals(s.getSmokeLevel(), o.getSmokeLevel());
		        }
		    }
	

}
