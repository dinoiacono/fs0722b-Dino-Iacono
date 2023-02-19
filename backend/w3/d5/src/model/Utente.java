package model;


import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Utente
 *
 */
@Entity

public class Utente  {

	@Id
	@Column(nullable = false, unique=true)
	private Integer tessera;
	
    @Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date data_nascita;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@OneToMany(mappedBy = "utente", cascade = CascadeType.REMOVE)
	private Set<Prestito> setPrestiti;
	
	public Utente() {
		super();
	}


	public Integer getTessera() {
		return tessera;
	}


	public void setTessera(Integer tessera) {
		this.tessera = tessera;
	}


	public Date getData_nascita() {
		return data_nascita;
	}


	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	@Override
	public String toString() {
		return "Utente [tessera=" + tessera + ", data_nascita=" + data_nascita + ", nome=" + nome + ", cognome="
				+ cognome + ", setPrestiti=" + setPrestiti + "]";
	}
	
	
   
}
