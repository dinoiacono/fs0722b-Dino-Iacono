package it.epicode.d4;

public class DipendenteBase extends Dipendente {
    
    private static double stipendioBase = 1000;

    public DipendenteBase(int matricola, Dipartimento dipartimento) {
        super(matricola, stipendioBase, 30, Livello.OPERAIO, dipartimento);
    }
    
}