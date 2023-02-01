package esercizioD2;

import java.util.Scanner;

public class Rettangolo {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		System.out.println("Esercizio Rettangolo pt 1");
		System.out.println("Scrivi il valore della base");
		System.out.print("Base: ");
		float B1 = Float.parseFloat(sc.nextLine());
		System.out.print("Altezza: ");
		float H1 = Float.parseFloat(sc.nextLine());
		stampaRett(B1, H1);
		
		System.out.println("-------------------------------------------------------");
		
		System.out.println("Esercizio Rettangolo pt 2");
		System.out.println("Scrivi il valore della base");
		System.out.print("Base: ");
		float B2 = Float.parseFloat(sc.nextLine());
		System.out.print("Altezza: ");
		float H2 = Float.parseFloat(sc.nextLine());
		stampa2Rett(B1, H1, B2, H2);
		
		
		System.out.println("-------------------------------------------------------");
		
		

	}
	
	public static void stampa2Rett(float h1, float b1, float h2, float b2 ) {
		System.out.println("L'area del rettangolo 1 è: " + areaRett(h1, b1) + ", ed il suo perimetro è: " + perRett(b1, h1) + "\nL'area del secondo rettangolo è: " + areaRett(h2, b2) + ", ed il suo perimetro è: " + perRett(h2, b2));
		System.out.println("La somma delle due aree è: " + (areaRett(h1, b1) + areaRett(h2, b2)) + ", e la somma dei perimetri è: " + (perRett(b1, h1) + perRett(h2, b2)));
	}
	
	public static void stampaRett(float h, float b ) {
		System.out.println("L'area del rettangolo è: " + areaRett(h, b) + ", ed il suo perimetro è: " + perRett(b, h));
	}
	
	public static double areaRett(float h, float b ) {
		return b*h;
	}
	public static double perRett(float h, float b ) {
		return (b+h)*2;
	}
	

}
