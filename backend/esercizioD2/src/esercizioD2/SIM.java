package esercizioD2;

import java.util.Scanner;

public class SIM {
	
	public static void main(String[] args) { 
		
		SIM sim1 = new SIM("123456789"); 
		
		sim1.stampaDatiSIM(); 
		System.out.println("-------------------------------------------------------\n");
		System.out.println("Effettua una ricarica!\n");
		System.out.print("Da quanto la vuoi effettuare la ricarica?");
		float ric = Float.parseFloat(sc.nextLine());
		ricarica(ric, sim1);
		sim1.stampaDatiSIM();
		System.out.println("-------------------------------------------------------\n");
//		System.out.println("Effettua una chiamata!\n");
//		System.out.print("Quanto vuoi parlare?");
//		float tempo = Float.parseFloat(sc.nextLine());
//		System.out.print("Inserisci il numero da chiamare?");
//		String numero = sc.nextLine();
//		
		
	} 

	static Scanner sc = new Scanner(System.in);
    private String numeroTelefono;
    private double credito;
    private Chiamata[] chiamate;

    public SIM(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
        this.credito = 0;
        this.chiamate = new Chiamata[5];
        this.chiamate[0] = new Chiamata(10 , "800 800 800");
    }

    public void stampaDatiSIM() {
        System.out.println("Numero di telefono: " + this.numeroTelefono);
        System.out.println("Credito disponibile: " + this.credito + "€");

        for (int i = 0; i < chiamate.length; i++) {
            if (chiamate[i] != null) {
                System.out.println("Chiamata n°" + (i + 1));
                System.out.println("Durata: " + chiamate[i].getDurata());
                System.out.println("Numero chiamato: " + chiamate[i].getNumeroChiamato()); 
            } else { 
                System.out.println("Chiamata n°" + (i+1) + " non effettuata"); 
            } 

        } 

    } 
    
    public static double ricarica(float r, SIM s) {
    	return s.credito += r;
    }


        class Chiamata{ 

            private int durata; 
            private String numeroChiamato; 

            public Chiamata(int durata, String numeroChiamato){ 
                this.durata = durata; 
                this.numeroChiamato = numeroChiamato; 
            } 

            public int getDurata(){ 
                return durata; 
            } 

            public String getNumeroChiamato(){ 
                return numeroChiamato; 
            } 

            }
    }
