package model;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Libro
 *
 */
@Entity
public class Libro extends Elemento {



	@Column(nullable = false)
	private String autore;
	
	@Column(nullable = false)
	private String genere;
	

	public Libro() {
		super();
	}
   
	public String getAutore() {
		return autore;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", getIsbn()=" + getIsbn() + ", getAnno()="
				+ getAnno() + ", getPagine()=" + getPagine() + ", getTitolo()=" + getTitolo() + "]";
	}

	
}
