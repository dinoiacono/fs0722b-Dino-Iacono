package com.example.spring.dispositivo;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.spring.security.auth.users.User;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "dispositivi")
@Data
@NoArgsConstructor
@ToString
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Status stato;
	
	@Enumerated(EnumType.STRING)
	private TipoDispositivo tipo;
    
    public Dispositivo(Status s, TipoDispositivo t) {
    	super();
    	this.stato = s;
    	this.tipo = t;
    }
}
