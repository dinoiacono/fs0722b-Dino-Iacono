package it.epicode.d5;

public class Rivista extends ElementoBibliotecario {

	 private Periodicita periodicita;

	    public Rivista(int ISBN, String titolo, int annoPub, int numeroPag, Periodicita periodicita) {
	        super(ISBN, titolo, annoPub, numeroPag);
	        this.periodicita = periodicita;
	    }

	    public Periodicita getPeriodicita() {
	        return periodicita;
	    }

	    @Override
	    public int getAnnoPub() {
	        return super.getAnnoPub();
	    }

	    @Override
	    public int getISBN() {
	        return super.getISBN();
	    }

	    @Override
	    public int getNumeroPag() {
	        return super.getNumeroPag();
	    }

	    @Override
	    public String getTitolo() {
	        return super.getTitolo();
	    }
	
}
