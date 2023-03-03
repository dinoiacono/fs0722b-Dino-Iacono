package it.epicode.D5.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "prenotazioni")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataPrenotazione;
	private Date dataScadenza;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_postazione", referencedColumnName = "id")
	private Postazione postazione;
	
	@ManyToOne
	@JoinColumn(name="id_utente")
	private Utente utente;
		
}
