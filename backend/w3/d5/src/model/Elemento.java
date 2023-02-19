package model;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Elemento
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Elemento {
	
	@Id
	@Column(nullable = false, unique=true)
	private Integer isbn;
	
	@Column(nullable = false)
	private Integer anno;
	
	@Column(nullable = false)
	private Integer pagine;
	
	@Column(nullable = false, unique=true)
	private String titolo;

	public Elemento() {
		super();
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public Integer getPagine() {
		return pagine;
	}

	public void setPagine(Integer pagine) {
		this.pagine = pagine;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "Elemento [isbn=" + isbn + ", anno=" + anno + ", pagine=" + pagine + ", titolo=" + titolo + "]";
	}
   
}
