package model;


import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Prestito
 *
 */
@Entity
public class Prestito {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	private Integer idPrestito;
	
	@Column(nullable = false)
	private Integer isbn;
	
	@Column(nullable = false)
	private Date data_inizio;
	
	@Column(nullable = false)
	private Date data_previsione;
	
	@Column(nullable = true)
	private Date data_fine;
	
	@ManyToOne
	private Utente utente;

	public Prestito() {
		super();
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	public Integer getIsbn() {
		return isbn;
	}


	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}


	public Date getData_inizio() {
		return data_inizio;
	}


	public void setData_inizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}


	public Date getData_previsione() {
		return data_previsione;
	}


	public void setData_previsione(Date data_previsione) {
		this.data_previsione = data_previsione;
	}


	public Date getData_fine() {
		return data_fine;
	}


	public void setData_fine(Date data_fine) {
		this.data_fine = data_fine;
	}


	public Integer getIdPrestito() {
		return idPrestito;
	}


	@Override
	public String toString() {
		return "Prestito [idPrestito=" + idPrestito + ", isbn=" + isbn + ", data_inizio=" + data_inizio
				+ ", data_previsione=" + data_previsione + ", data_fine=" + data_fine + "]";
	}
	
	
   
}
