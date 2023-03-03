package it.epicode.D5.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "edificii")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String indirizzo;
	private String citta;
	
	@OneToMany( mappedBy = "edificio", cascade = CascadeType.ALL )
	private List<Postazione> postazioni;
		
}
