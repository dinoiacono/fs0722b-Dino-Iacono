package it.epicode.D5.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "postazioni")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Postazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	private int maxUtenti;
	private Boolean disponibilita;
	
	@ManyToOne
	@JoinColumn(name="id_edificio")
	private Edificio edificio;
	
	@OneToOne(mappedBy = "postazione")
	private Prenotazione prenotazione;
	
	public void setMaxUtenti() {
		switch (tipo) {
		case OPENSPACE:
			this.maxUtenti = 50;
			break;
		case PRIVATO:
			this.maxUtenti = 1;
			break;
		case SALARIUNIONI:
			this.maxUtenti = 70;
			break;
		default: this.maxUtenti = 1;
			break;
		}	
	}
	
	public void setDisponibilita() {
		if (this.prenotazione == null) this.disponibilita = true;
		else this.disponibilita = false;
	}
}

