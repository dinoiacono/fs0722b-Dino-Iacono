package it.epicode.d5w2;

public abstract class ElementoBibliotecario {
    
   private int ISBN;
   private String titolo;
   private int annoPub;
   private int numeroPag;

   public ElementoBibliotecario(int ISBN, String titolo, int annoPub, int numeroPag) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.annoPub = annoPub;
        this.numeroPag = numeroPag;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPub() {
        return annoPub;
    }

    public int getNumeroPag() {
        return numeroPag;
    }
}