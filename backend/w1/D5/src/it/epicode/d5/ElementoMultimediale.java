package it.epicode.d5;

public abstract class ElementoMultimediale implements Regolazioni {

    public String titolo;
    public Tipo tipo;

    public ElementoMultimediale(String titolo, Tipo tipo) {
        this.titolo = titolo;
        this.tipo = tipo;
    }
  
}