package com.GestioneIncendi.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.GestioneIncendi.models.ProcessoDispositivo;

class TestProcessoDispositivo {
	static ProcessoDispositivo d;
	
	
	@BeforeClass
	public static void creaSondaEProcess() {
		d = new ProcessoDispositivo(1L, 2);
	}
	
	@Test
	void testUpdate() {
			assertNotNull(d.getSmokeLevel());	
	}

}
