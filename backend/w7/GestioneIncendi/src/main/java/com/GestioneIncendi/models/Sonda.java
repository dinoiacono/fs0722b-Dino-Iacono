package com.GestioneIncendi.models;

import java.util.HashSet;
import java.util.Set;

import com.GestioneIncendi.services.ProcessService;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sonda extends Dispositivo {
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ProcessoDispositivo> listaProcessi = new HashSet<ProcessoDispositivo>();
	
	private Integer latitude;
	private Integer longitude;
	private Integer smokeLevel;
	
	
	public Sonda(TipoDispositivo type, Integer latitude, Integer longitude, Integer smokeLevel) {
		this.type = TipoDispositivo.SONDA;
		this.latitude = latitude;
		this.longitude = longitude;
		this.smokeLevel = smokeLevel;
	}

	public Sonda(Long id, TipoDispositivo type, Integer latitude, Integer longitude, Integer smokeLevel) {
		super(id, type);
		this.type = TipoDispositivo.SONDA;
		this.latitude = latitude;
		this.longitude = longitude;
		this.smokeLevel = smokeLevel;
	}

	@Override
	public String toString() {
		return "Sonda [latitude=" + latitude + ", longitude=" + longitude + ", smokeLevel=" + smokeLevel + ", getId()="
				+ getId() + ", getType()=" + getType() + "]";
	}




	


	
	
}
