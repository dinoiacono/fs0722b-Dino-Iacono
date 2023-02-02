package it.epicode.d4;

public class Dipendente {
    
    private int matricola;
    private double stipendio;
    private double importoOrarioStraordinario;
    private LivelloEnum livello;
    private DipartimentoEnum dipartimento;
    static double stipendioBase = 1000;

    public Dipendente(int matricola, DipartimentoEnum dipartimento) {
        this.matricola = matricola;
        this.dipartimento = dipartimento;
        this.stipendio = stipendioBase;
        this.importoOrarioStraordinario = 30;
        this.livello = LivelloEnum.OPERAIO;
    }
    
    
    public Dipendente(int matricola, double stipendio, double importoOrarioStraordinario, LivelloEnum livello ,DipartimentoEnum dipartimento) {
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

    public LivelloEnum getLivello() {
        return livello;
    }

    public DipartimentoEnum getDipartimento() {
        return dipartimento;
    }


    public double getImportoOrarioStraordinario() {
        return importoOrarioStraordinario;
    }

    public void setDipartimento(DipartimentoEnum d) {
        this.dipartimento = d;
    }

    public void setimportoOrarioStraordinario(double imp) {
        this.importoOrarioStraordinario = imp;
    }


    public void stampaDipendente(){
        System.out.println("Dipendente: \nMatricola: " + this.getMatricola() + "\nStipendio: " + this.getStipendio() + "\nImporto Straordinari: " + this.importoOrarioStraordinario + "\nLivello: " + this.getLivello() + "\nDipartimento: " + this.dipartimento);
    }

    public LivelloEnum setLivello(){
        switch(this.livello){
            case OPERAIO:
                return LivelloEnum.IMPIEGATO;
            case IMPIEGATO:
                return LivelloEnum.QUADRO;
            case QUADRO:
                return LivelloEnum.DIRIGENTE;
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
    public double calcolaPaga() {
        return this.getStipendio();
    }
    public double calcolaPaga(int h) {
        return (this.getImportoOrarioStraordinario() * h) + this.getStipendio();
    }

}