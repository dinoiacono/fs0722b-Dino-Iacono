package it.epicode.d5w2;

public class Libro extends ElementoBibliotecario {
    
    private String autore;
    private String genere;
    
    public Libro(int ISBN, String titolo, int annoPub, int numeroPag, String autore, String genere) {
        super(ISBN, titolo, annoPub, numeroPag);
        this.autore = autore;
        this.genere = genere;
    }
    public String getAutore() {
        return autore;
    }
    public String getGenere() {
        return genere;
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