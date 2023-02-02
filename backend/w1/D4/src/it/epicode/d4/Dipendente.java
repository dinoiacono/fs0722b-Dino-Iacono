package it.epicode.d4;

public abstract class Dipendente {
    
    public enum Livello{
        OPERAIO,
        IMPIEGATO,
        QUADRO,
        DIRIGENTE
    }

    public enum Dipartimento{
      PRODUZIONE,
      AMMINISTRAZIONE,
      VENDITE
    }

    
    private int matricola;
    private double stipendio;
    public double importoOrarioStraordinario;
    private Livello livello;
    public Dipartimento dipartimento;
    private static double stipendioBase = 1000;
    
    
    public Dipendente(int matricola, double stipendio, double importoOrarioStraordinario, Livello livello ,Dipartimento dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.importoOrarioStraordinario = importoOrarioStraordinario;
        this.livello = livello;
        this.dipartimento = dipartimento;
    }
    
    public int getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public Livello getLivello() {
        return livello;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }


    public double getImportoOrarioStraordinario() {
        return importoOrarioStraordinario;
    }


    public void stampaDipendente(){
        System.out.println("Dipendente: \nMatricola: " + this.getMatricola() + "\nStipendio: " + this.getStipendio() + "\nImporto Straordinari: " + this.importoOrarioStraordinario + "\nLivello: " + this.getLivello() + "\nDipartimento: " + this.dipartimento);
    }

    public Livello setLivello(){
        switch(this.livello){
            case OPERAIO:
                return Livello.IMPIEGATO;
            case IMPIEGATO:
                return Livello.QUADRO;
            case QUADRO:
                return Livello.DIRIGENTE;
            case DIRIGENTE:
                System.out.println("Sei già dirigente e ti paghiamo un botto");
                break;
            default:
                break;
        }
        return this.livello;
    }

    public void setStipendio(){
        switch (this.livello) {
            case IMPIEGATO:
                this.stipendio = stipendioBase * 1.2;
                break;
            case QUADRO:
                this.stipendio = stipendioBase * 1.5;
                break;
            case DIRIGENTE:
                this.stipendio = stipendioBase * 2;
                break;
            default:
                this.stipendio = stipendioBase;
                break;
        }
        
    }

    public void promozione(){
        this.livello= setLivello();
        setStipendio();
    }

}