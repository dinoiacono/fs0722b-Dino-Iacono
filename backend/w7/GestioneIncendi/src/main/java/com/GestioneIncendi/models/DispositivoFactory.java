package com.GestioneIncendi.models;

public class DispositivoFactory {

	public static Dispositivo createDevice(TipoDispositivo type) {
		
		if (type == null) {
			return null;
		}
		if (type.equals(TipoDispositivo.SONDA)) {
			return new Sonda(TipoDispositivo.SONDA, 0, 0, 0);
		}
		return null;
	}
}
