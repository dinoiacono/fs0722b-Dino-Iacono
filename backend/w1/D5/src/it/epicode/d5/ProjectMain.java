package it.epicode.d5;

import java.util.Scanner;

public class ProjectMain {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // Questo è l'array che conterrà tutti gli elementi multimediali
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        System.out.println("\nEserczio settimanale!!\n");

        /*
         * Questo ciclo for serve per far avvennire la switch
         * tante volte quanti elementi sono da creare
         * in base alla lunghezza dell'array che li conterrà
         */
        for (int i = 0; i < elementi.length; i++) {
            System.out.println("Scegli cosa vuoi creare tra: \n\n1)Audio;\n2)Video;\n3)Foto;\n0)Esci.");
            // --------------------------------------------------------------------------------------------------------------
            /*
             * In questa switch scegli cosa vuoi creare
             */

            int scelta = sc.nextInt();
            switch (scelta) {
                case 1:
                int durata_audio = 1;
                try {
                    System.out.print("Inserisci la durata : ");
                    durata_audio = sc.nextInt(); 
                } catch (Exception e) {
                    System.out.println("Errore! L'input non è valido! dovevi inserire un numero!\nLa durata base è di " + durata_audio + "minuti.");
                }
                    sc.nextLine();
                    System.out.println("inserisci il titolo: ");
                    String titolo_audio = sc.nextLine();
                    elementi[i] = new Audio(titolo_audio, durata_audio);
                    break;
                case 2:
                int durata_video = 1;
                try {
                    System.out.print("Inserisci la durata : ");
                    durata_video = sc.nextInt(); 
                } catch (Exception e) {
                    System.out.println("Errore! L'input non è valido! dovevi inserire un numero!\nLa durata base è di " + durata_video + "minuti.");
                }
                    sc.nextLine();
                    System.out.println("inserisci il titolo: ");
                    String titolo_video = sc.nextLine();
                    elementi[i] = new Video(titolo_video, durata_video);
                    break;
                case 3:
                    System.out.println("inserisci il titolo: ");
                    sc.nextLine();
                    String titolo_foto = sc.nextLine();
                    elementi[i] = new Foto(titolo_foto);
                    break;
                case 0:
                    System.out.println("Grazie per aver usato il programma!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nScelta non valida!!\n");
                    i--;
                    break;
            }

        }
        // --------------------------------------------------------------------------------------------------------------

        /*
         * Una volta terminata la creazione degli elementi si passa alla scelta della
         * visualizzazione
         * non prima di aver deciso se effettuare qualche controllo
         * con i metodi creati nelle varie classi
         */
        while (true) {
            System.out.println("Scegli cosa vuoi vedere tra: \n\n1)" + elementi[0].titolo + "\n2)" + elementi[1].titolo
                    + "\n3)" + elementi[2].titolo + "\n4)" + elementi[3].titolo + "\n5)" + elementi[4].titolo);
            int scelta = sc.nextInt();
            switch (scelta) {
                case 1:
                    mostraControlli(elementi[0]);
                    break;
                case 2:
                    mostraControlli(elementi[1]);
                    break;
                case 3:
                    mostraControlli(elementi[2]);
                    break;
                case 4:
                    mostraControlli(elementi[3]);
                    break;
                case 5:
                    mostraControlli(elementi[4]);
                    break;
                case 0:
                    System.out.println("Grazie per aver usato il programma!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }

        }
    }
    // --------------------------------------------------------------------------------------------------------------

    /*
     * In questo metodo viene scelto il tipo di
     * controlli che si possono usare in base
     * al tipo di elemento
     */

    public static void mostraControlli(ElementoMultimediale e) {
        if (e.tipo == Tipo.FOTO) {
            System.out.println("\nVuoi regolare la luminosità prima di vedere l'immagine " + e.titolo
                    + "?\n\nTi ricordo che di default la luminosità è al massimo.");
            System.out.println("1)Abbassa la luminosità;\n2)Alza la luminosità;\n3)Mostra l'immagine.");
            int scelta = sc.nextInt();
            switch (scelta) {
                case 1:
                    e.abbassaLum();
                    break;
                case 2:
                    e.alzaLum();
                    break;
                case 3:
                    stampa(e);
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        } else if (e.tipo == Tipo.AUDIO) {
            System.out.println("Vuoi regolare il volume di " + e.titolo
                    + " prima di ascoltarlo?\nTi ricordo che di default il volume è al massimo.");
            System.out.println("1)Abbassa volume;\n2)Alza volume;\n3)Ascolta audio.");
            int scelta = sc.nextInt();
            switch (scelta) {
                case 1:
                    e.abbassaVol();
                    break;
                case 2:
                    e.alzaVol();
                    break;
                case 3:
                    stampa(e);
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        } else {
            System.out.println("Vuoi regolare il volume e la luminosità di " + e.titolo
                    + " prima di vederlo?\nTi ricordo che di default la luminosità ed il volume sono al massimo.");
            System.out.println("1)Abbassa la luminosità;\n2)Alza la luminosità;\n3)Mostra l'immagine.");
            int scelta = sc.nextInt();
            switch (scelta) {
                case 1:
                    e.abbassaVol();
                    break;
                case 2:
                    e.alzaVol();
                    break;
                case 3:
                    e.abbassaLum();
                    break;
                case 4:
                    e.alzaLum();
                    break;
                case 5:
                    stampa(e);
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }

    }

    // --------------------------------------------------------------------------------------------------------------

    /*
     * In questo metodo viene scelto il tipo di stampa che si può effettuare
     * in base al tipo di elemento
     */

    public static void stampa(ElementoMultimediale e) {
        if (e.tipo == Tipo.FOTO)
            ((Foto) e).show();
        else
            e.play();
    }
}
