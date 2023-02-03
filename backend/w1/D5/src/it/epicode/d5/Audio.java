package it.epicode.d5;

import java.util.StringJoiner;

public class Audio extends ElementoMultimediale {

   private int volume = 10;
    int durata;

    public Audio(String titolo, int durata) {
        
        super(titolo, Tipo.AUDIO);
        this.durata = durata;

        
    }
    
    @Override
    public void play(){
        StringJoiner s = new StringJoiner(" ");
        s.add(this.titolo);
        for (int i = 0; i < this.volume; i++) {
         s.add("!");
        }
        for (int i = 0; i < this.durata; i++) {
            System.out.println(s.toString());
        }
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
    public void alzaLum() {}

    @Override
    public void abbassaLum() {}
    
}