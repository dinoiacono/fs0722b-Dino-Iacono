package model;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rivista
 *
 */
@Entity

public class Rivista extends Elemento{

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Periodicita periodo;
	

	public Rivista() {
		super();
	}


	public Periodicita getPeriodo() {
		return periodo;
	}


	public void setPeriodo(Periodicita periodo) {
		this.periodo = periodo;
	}


	@Override
	public String toString() {
		return "Rivista [periodo=" + periodo + ", getIsbn()=" + getIsbn() + ", getAnno()=" + getAnno()
				+ ", getPagine()=" + getPagine() + ", getTitolo()=" + getTitolo() + "]";
	}
	
	
   
}
