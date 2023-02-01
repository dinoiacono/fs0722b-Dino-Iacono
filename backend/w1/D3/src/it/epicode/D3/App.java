package it.epicode.D3;


import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        // System.out.println("Esercizio 1 parte 1");
		// System.out.print("Scrivi una parola: ");
		// String str = sc.nextLine();
        // stringaPariDispari(str);
		// System.out.println("-------------------------------------------------------");

        System.out.println("Esercizio 1 parte 2");
		System.out.print("Scrivi un anno:  ");
		int anno = Integer.parseInt(sc.nextLine());
        annoBisestile(anno);
		System.out.println("-------------------------------------------------------");
        

    }

    public static void stringaPariDispari(String s) {
        if (s.length()%2 == 0) {
            System.out.println("Il numero di caratteri è pari");
        } else {
            System.out.println("Il numero di caratteri è dispari");
        }
    }

    public static void annoBisestile(int a) {
        if (a % 4 == 0 || (a % 100 == 0 && a % 400 == 0)) {
            System.out.println("L' anno " + a + " è bisestile");
        } else {
            System.out.println("L' anno " + a + " non è bisestile");
        }
    }

}
