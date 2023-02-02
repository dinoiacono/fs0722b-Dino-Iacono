package it.epicode.d4;

import it.epicode.d4.Dipendente.Dipartimento;

public class App {
    public static void main(String[] args) throws Exception {
        
        DipendenteBase d1 = new DipendenteBase(1, Dipartimento.AMMINISTRAZIONE);

        d1.stampaDipendente();
        d1.promozione();
        d1.stampaDipendente();
        System.out.println("Lo stipendio del dipendente senza straordinari è: " + calcolaPaga(d1));
        System.out.println("Lo stipendio del dipendente con straordinari è: " + calcolaPagaStraoirdinaria(d1, 10));

    }

    public static double calcolaPaga(Dipendente x) {
        return x.getStipendio();
    }
    public static double calcolaPagaStraoirdinaria(Dipendente x, int h) {
        double pagaExtra = x.getImportoOrarioStraordinario() * h;
        return x.getStipendio() + pagaExtra;
    }
}
