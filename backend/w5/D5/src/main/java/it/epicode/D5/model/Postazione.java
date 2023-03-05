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
	
	public void stampaPostazione(){
		System.out.println(this.tipo + ", " + this.descrizione + ", " + this.maxUtenti + ", " + this.edificio.getNome()  + ", " +  this.edificio.getCitta() + ", " + this.edificio.getIndirizzo());
	}
	
}

