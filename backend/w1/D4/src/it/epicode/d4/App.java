package it.epicode.d4;


public class App {
    public static void main(String[] args) throws Exception {
        
        Dipendente d1 = new Dipendente(1, DipartimentoEnum.PRODUZIONE);
        Dipendente d2 = new Dipendente(2, DipartimentoEnum.PRODUZIONE);
        Dipendente imp = new Dipendente(3, Dipendente.stipendioBase * 1.2, 30, LivelloEnum.IMPIEGATO, DipartimentoEnum.AMMINISTRAZIONE);
        Dipendente dir = new Dipendente(4, Dipendente.stipendioBase * 2, 30, LivelloEnum.DIRIGENTE, DipartimentoEnum.VENDITE);

        
        
        d1.stampaDipendente();
        System.out.println("----------------------------------------------------------------");
        d2.promozione();
        d2.stampaDipendente();
        System.out.println("----------------------------------------------------------------");
        imp.promozione();
        imp.stampaDipendente();
        System.out.println("----------------------------------------------------------------");
        dir.stampaDipendente();
        System.out.println("----------------------------------------------------------------");

        System.out.println("Il totale degli stipendi è: " + (d1.calcolaPaga(d1, 5) + d2.calcolaPaga(d2, 5) + imp.calcolaPaga(imp, 5) + dir.calcolaPaga(dir, 5)) + "€");
    }
}