package it.epicode.d5;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProjectMain {
	
	static Scanner sc = new Scanner(System.in);
    public static Map<Integer, Libro> listaLibri=new HashMap<Integer, Libro>(); 
    public static Map<Integer, Rivista> listaRiviste=new HashMap<Integer, Rivista>();
	
    public static void main(String[] args) throws Exception {
        pulisciConsole();
        while (true) {
            System.out.println("\nBenvenuto in biblioteca, che vuoi fare?");
            System.out.println("\n1)Crea un nouvo elemento;\n" + "2)Rimuovi un elemento tramite il codice ISBN;\n" + "3)Trova un elemento tramite il codice ISBN;\n" + "4)Vedi tutti i libri usciti nell'anno che desideri;\n" + "5)Vedi tutti i libri dell'autore che desideri;\n" + "6)Vedi tutti i libri e le riviste che abbaimo;\n" + "0)Esci.\n");
            int scelta = sc.nextInt();
            switch (scelta) {
            case 1:
                nuovoElemento();
                break;
            case 2:

                cancellaConIsbn();
                break;
            case 3:

                ricercaConISBN();
                break;
            case 4:

                ricercaConAnno();
                break;
            case 5:

                ricercaConAutore();
                break;
            case 6:

                stampaCatalogo();
                break;
            case 0:
                System.out.println("Grazie per aver usato il programma!");
                System.exit(0);
                break;
            default:
                break;
            }
        } 
    }

/*
 * Metodo che genera un nuovo elemento
 * tramite la scelta dell'utente
 */

    public static void nuovoElemento() {
        try {
            System.out.println("Cosa vuoi aggiungere?");
            System.out.print("1)Libro\n2)Rivista");
            int codice = sc.nextInt();
            switch (codice) {
                case 1://libro
                    sc.nextLine();
                    System.out.print("Nome autore: ");
                    String autore = sc.nextLine();
                    System.out.print("Titolo: ");
                    String titoloL = sc.nextLine();
                    System.out.print("Genere: ");
                    String genere = sc.nextLine();
                    System.out.print("Anno di pubblicazione: ");
                    int annoL = sc.nextInt();
                    System.out.print("Numero pagine: ");
                    int numeroPagL = sc.nextInt();
                    int isbnL = creaCodiceISBN();
                    listaLibri.put(isbnL,new Libro(isbnL, titoloL, annoL, numeroPagL, autore, genere));
                    break;
                case 2://rivista
                    sc.nextLine();
                    System.out.print("Titolo");
                    String titoloR = sc.nextLine();
                    System.out.print("Annio di pubblicazione: ");
                    int annoR = sc.nextInt();
                    System.out.print("Numero pagine: ");
                    int numPagR = sc.nextInt();
                    System.out.println("Periodicità");
                    System.out.print("1)Settimanale\n2)Mensile\n3)Semestrale");
                    Periodicita p = Periodicita.SETTIMANALE;
                    int s = sc.nextInt();
                    switch (s) {
                        case 1:
                            p = Periodicita.SETTIMANALE;
                            break;
                        case 2:   
                            p = Periodicita.MENSILE;
                            break;
                        case 3:    
                            p = Periodicita.SEMESTRALE;
                            break;
                        default:
                            break;
                    }
                    int isbnR = creaCodiceISBN();
                    listaRiviste.put(isbnR, new Rivista(isbnR, titoloR, annoR, numPagR, p));
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

/*
 * Metodo che cancella un libro o un rivista dal catalogo
 * usando il codice ISBN come parametro
 */

    public static void cancellaConIsbn() {;
        stampaCatalogo();
     System.out.println("\nInserici il numero ISBN del libro o rivista da cancellare: \n");
     try {
        int isbnDaEliminare = sc.nextInt();
        listaLibri.remove(isbnDaEliminare);
        listaRiviste.remove(isbnDaEliminare);
     } catch (Exception e) {
       System.out.println("Inserisci un numero valido!!");
     } 
    }

/*
 * Metodo che trova un libro o un rivista dal catalogo
 * usando il codice ISBN come parametro
 */

    public static void ricercaConISBN() {
        System.out.println("\nInserici il numero ISBN del libro o rivista da trovare: \n");
       try {
        int isbnFind = sc.nextInt();
        listaLibri.entrySet().stream()
        .filter(l -> l.getKey().equals(isbnFind))
        .forEach(element -> System.out.println("\n---------------Libri---------------\nTitolo: " + element.getValue().getTitolo() + "\nAutore: " + element.getValue().getAutore()));
        listaRiviste.entrySet().stream()
        .filter(r -> r.getKey().equals(isbnFind))
        .forEach(element -> System.out.println("\n---------------Riviste---------------\nTitolo: " + element.getValue().getTitolo()));
       } catch (Exception e) {
        // TODO: handle exception
       } 

    }
    
/*
 * Metodo che trova un libro o un rivista dal catalogo
 * usando l'anno come parametro
 */

    public static void ricercaConAnno() {
        System.out.println("\nInserici l'anno per stampare tutti i libri e le riviste pubblicate in quell'anno: \n");
        try {
         sc.nextLine();
         int annoFind = sc.nextInt();
         listaLibri.entrySet().stream()
         .filter(l -> l.getValue().getAnnoPub() == annoFind)
         .forEach(element -> System.out.println("\n---------------Libri---------------\nTitolo: " + element.getValue().getTitolo() + "\nAutore: " + element.getValue().getAutore()));
         listaRiviste.entrySet().stream()
         .filter(r -> r.getValue().getAnnoPub() == annoFind)
         .forEach(element -> System.out.println("\n---------------Riviste---------------\nTitolo: " + element.getValue().getTitolo()));
        } catch (Exception e) {
         // TODO: handle exception
        }   
    }

/*
 * Metodo che trova un libro o un rivista dal catalogo
 * usando l'autore come parametro
 */

    public static void ricercaConAutore() {
        System.out.println("\nInserici il nome dell'autore del quale vuoi vedere i libri: \n");
        try {
        sc.nextLine();
         String autoreFind = sc.nextLine();
         listaLibri.entrySet().stream()
        .filter(l -> l.getValue().getAutore().equals(autoreFind))
        .forEach(element -> System.out.println("\n---------------Libri---------------\nTitolo: " + element.getValue().getTitolo() + "\nAutore: " + element.getValue().getAutore()));
        } catch (Exception e) {
         // TODO: handle exception
        }   
    }

/*
 * Metodo che crea un codice ISBN
 */

    public static int creaCodiceISBN() {
        return (int)(Math.random()*9000)+1000;
    }

/*
 * Metodo per stampare il catalogo
 */

    public static void stampaCatalogo(){
        System.out.println("--------------------------------Libri--------------------------------");
        listaLibri.forEach((key, value) -> System.out.println("ISBN: " + key + "= Autore: " + value.getAutore()+", Titolo: " + value.getTitolo() + ", Genere: " + value.getGenere() + ", Anno di pubblicazione: " + value.getAnnoPub() + ", Numero pagine: " + value.getNumeroPag() + ";\n" ));
        System.out.println("-------------------------------Riviste-------------------------------");
        listaRiviste.forEach((key, value) -> System.out.println("ISBN: " + key + "= Titolo: " + value.getTitolo() + ", Anno di pubblicazione: " + value.getAnnoPub() + ", Numero pagine: " + value.getNumeroPag() + ";\n" ));
    }

/*
 * Metodo per trovare un libro con il parametro desiderato
 */

    public static void trovaLibro(Object x) {
        listaLibri.entrySet().stream()
        .filter(l -> l.getKey().equals(x))
        .forEach(element -> System.out.println("\n---------------Libri---------------\nTitolo: " + element.getValue().getTitolo() + "\nAutore: " + element.getValue().getAutore()));
    }    
    
/*
 * Metodo per trovare una rivista con il parametro desiderato
 */

    public static void trovaRivista(Object x) {
        listaRiviste.entrySet().stream()
         .filter(r -> r.getKey().equals(x))
         .forEach(element -> System.out.println("\n---------------Riviste---------------\nTitolo: " + element.getValue().getTitolo()));
    }
    
/*
 * Metodo per pulire la console
 */

    public static void pulisciConsole() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
}

