package it.epicode.d4;

public class DipendenteBase extends Dipendente {

    public DipendenteBase(int matricola, DipartimentoEnum dipartimento) {
        super(matricola, stipendioBase, 30, LivelloEnum.OPERAIO, dipartimento);
    }
    
}