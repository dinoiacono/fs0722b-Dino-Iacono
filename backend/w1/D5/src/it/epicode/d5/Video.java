package it.epicode.d5;

import java.util.StringJoiner;

public class Video extends ElementoMultimediale {

    private int volume = 10;
    private int luminosita = 10;
    private int durata;

    public Video(String titolo, int durata) {
        super(titolo, Tipo.VIDEO);
        this.durata = durata;
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
    public void alzaVol() {
        if (this.volume < 10) this.volume++;        
    }
    @Override
    public void abbassaVol() {
        if (this.volume > 0) this.volume--;   
    }

    @Override
    public void play(){
        StringJoiner s = new StringJoiner(" ");
        s.add(this.titolo);
        for (int i = 0; i < this.volume; i++) {
         s.add("!");
        }
        for (int i = 0; i < this.luminosita; i++) {
            s.add("*");}
        for (int i = 0; i < this.durata; i++) {
            System.out.println(s.toString());
        }
     }
    
    
}