package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

public static void main (String[] args)
		{
	
		Scanner sc = new Scanner(System.in);
	
		System.out.println("------------Esercizio 1-------------");
		
		//prima parte
		
		System.out.println("Scrivi due numeri da moltiplicare");
		System.out.print("Numero 1: ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("Numero 2: ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.println("Il risultato è: "+ moltiplica(num1, num2));
		
		System.out.println("-------------------------------------------------------");
		
		//seconda parte
		
		System.out.println("concatena testo e numero");
		System.out.print("Testo: ");
		String txt = sc.nextLine();
		System.out.print("Numero: ");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("Ecco il risultato: " + concatena(txt, num));
		
		System.out.println("-------------------------------------------------------");
		
		//terza parte
		
		System.out.println("Inserimento in array");
		
		System.out.println("-------------------------------------------------------");

		System.out.println("------------Esercizio 2-------------");
		
		System.out.println("Concatena 3 stringhe");
		System.out.print("Testo 1: ");
		String txt1 = sc.nextLine();
		System.out.print("Testo 2: ");
		String txt2 = sc.nextLine();
		System.out.print("Testo 3: ");
		String txt3 = sc.nextLine();
		System.out.println("Ecco il risultato: " + concatenaStringhe(txt1, txt2, txt3));
		System.out.println("Ecco il risultato: " + concatenaStringhe(txt3, txt2, txt1));
		
		System.out.println("-------------------------------------------------------");
		
		System.out.println("------------Esercizio 3-------------");
		
		//prima parte
		
		System.out.println("Scrivi le lunghezze dei lati ed avrai il perimetro del rettamvgolo");
		System.out.print("Lato 1: ");
		float lato1 = Float.parseFloat(sc.nextLine());
		System.out.print("Numero 2: ");
		float lato2 = Float.parseFloat(sc.nextLine());
		System.out.println("Il risultato è: "+ perimetroRettangolo(lato1, lato2));
		
		System.out.println("-------------------------------------------------------");
		
		//seconda parte
		
		System.out.println("Scrivi un numero e vedi se è dispari o pari");
		System.out.print("numero: ");
		int numero = Integer.parseInt(sc.nextLine());
		System.out.println(pariDispari(numero));
		
		System.out.println("-------------------------------------------------------");
		
		//terza parte
		
		System.out.println("Scrivi le lunghezze dei lati ed avrai l'area triangolo");
		System.out.print("Lato 1: ");
		float l1 = Float.parseFloat(sc.nextLine());
		System.out.print("Lato 2: ");
		float l2 = Float.parseFloat(sc.nextLine());
		System.out.print("Lato 2: ");
		float l3 = Float.parseFloat(sc.nextLine());
		System.out.println("Il risultato è: "+ areaTriangolo(l1, l2, l3));
		
		System.out.println("-------------------------------------------------------");
		
		System.out.println("-----------------------FINE!-----------------------");
		}

		//Metodi esercizio 1

public static int moltiplica (int a, int b){
		return a * b;
		}

//-------------------------------------

public static String concatena (String a, int b){
	return (a + " " + b);
	}


		//Metodo esercizio 2

public static String concatenaStringhe (String a, String b, String c ){
	return a + " " + b + " " + c ;
	}

		//Metodi esercizio 3

public static float perimetroRettangolo (float a, float b ){
	return (a + b) * 2;
	}

//-------------------------------------

public static int pariDispari (int a){
		if (a % 2 == 0) {
			return 0;
		}else {
			return 1;
		}
	}

//-------------------------------------

public static double areaTriangolo (float a, float b, float c){
		float p = (a+b+c)/2;
		return Math.sqrt( p * (p - a) * (p - b) * (p - c));
}





}