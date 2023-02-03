package it.epicode.d5;

import java.util.StringJoiner;

public class Foto extends ElementoMultimediale{

    private int luminosita = 10;
 

    public Foto(String titolo) {
        super(titolo,Tipo.FOTO);

    }

    public void show(){
       StringJoiner s = new StringJoiner(" ");
       s.add(this.titolo);
       for (int i = 0; i < this.luminosita; i++) {
        s.add("*");
       }
       System.out.println(s.toString());
    }

    @Override
    public void alzaLum() {
        if (this.luminosita < 10) this.luminosita++; 
    }

    @Override
    public void abbassaLum() {
        if (this.luminosita > 0) this.luminosita--; 
    }

    @Override
    public void alzaVol() {}

    @Override
    public void abbassaVol() {}

    @Override
    public void play() {}
    
    
}