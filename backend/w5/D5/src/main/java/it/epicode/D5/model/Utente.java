package it.epicode.D5.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "utenti")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	private String username;
	@Column(unique = true)
	private String email;
	
	@Column(nullable = true)
	@OneToMany( mappedBy = "utente", cascade = CascadeType.ALL )
	private List<Prenotazione> prenotazioni;
		
}

