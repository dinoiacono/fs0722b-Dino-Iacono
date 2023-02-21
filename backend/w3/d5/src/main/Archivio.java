package main;


import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.*;


public class Archivio {

	static Logger log = LoggerFactory.getLogger(Archivio.class);
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("D5");

	
	public static void main(String[] args) throws ParseException {

		Libro l1 = new Libro();
		l1.setAnno(2021);
		l1.setAutore("pippo");
		l1.setGenere("bambini");
		l1.setPagine(100);
		l1.setIsbn(isbnGenerator());
		l1.setTitolo("coccodrillo");
		
		Utente u1 = new Utente();
		u1.setNome("Giggio");
		u1.setCognome("de giggis");
		u1.setTessera(codiceTessera());
		u1.setData_nascita(new GregorianCalendar(2000,04, 05).getTime());
		
		Rivista r1 = new Rivista();
		r1.setAnno(2021);
		r1.setIsbn(isbnGenerator());
		r1.setPagine(20);
		r1.setPeriodo(Periodicita.SEMESTRALE);
		r1.setTitolo("pippo e pluto");
		
		Prestito p1 = new Prestito();
		p1.setIsbn(984374);
		p1.setUtente(ricercaUtentePerTessera(8929));
		GregorianCalendar data = new GregorianCalendar(2023,02, 04);
		p1.setData_inizio(data.getTime());
		data.add((GregorianCalendar.MONTH), 1);
		p1.setData_previsione(data.getTime());
		
/*
 * 	QUESTI SONO I METODI PER POPOLARE IL DB
 */
		
		//aggiungiElemento(l1);
		//aggiungiElemento(r1);
		//aggiungiUtente(u1);
		//aggiungiPrestito(p1);

//-----------------------------------------------
		
/*
 * QUESTO METODO VA A RICERCARE TUTTI GLI ELEMENTI CHE HANNO NEL LORO TITOLO 
 * LA STRINGA INSERITA NON TENENDO CONTO DI MAIUSCOLE O MINUSCOLE
 */
	
//		List<Elemento> lista1 = ricercaElementiPerTitolo("cocco");
//		
//		for (Elemento e : lista1) {
//			System.out.println(e.toString());
//		}
		
//------------------------------------------------
		
/*
 * QUESTO METODO RITORNA UNA LISTA CON TUTTI GLI ELEMENTI PUBBLICATI NELL'ANNO INSERITO
 */
		
//		List<Elemento> lista2 = ricercaElementiPerAnno(2021);
//		
//		for (Elemento e : lista2) {
//		System.out.println(e.toString());
//	}
		
//------------------------------------------------
	
/*
* QUESTO METODO RICERCA TUTTI I LIBRI SCRITTI DA UN AUTORE
*/
		
//		List<Libro> lista3 = ricercaLibriPerAutore("pippo");
//		
//		for (Elemento e : lista3) {
//		System.out.println(e.toString());
//	}
		
//------------------------------------------------
		
/*
 * QUESTO METODO RICERCA GLI ELEMENTI PRESI IN PRESTITO DA UN'UTENTE
 * TRAMITE IL SUO NUMERO DI TESSERA 
 */
		
//		List<Prestito> lista4 = ricercaElementiInPrestito(8929);
//		
//		for (Prestito e : lista4) {
//		System.out.println(e.toString());
//	}
		
//-----------------------------------------------
		
/*
 * QUESTO METODO RICERCA TUTTI I PRESTITI SCADUTI E NON RESTITUITI 
 * FINO ALLA DATA CHE VIENE MESSA IN INPUT
 */
		
//		ricercaPrestitiScaduti(new GregorianCalendar(2023, 05, 04));
		
//------------------------------------------------
		
/*
 * QUESTO METODO IMPOSTA LA FINE DEL PRESTITO TRAMITE L'ID DEL PRESTITO 
 * E LA DATA DA IMPOSTARE COME FINE 
 */
		
//		impostaFinePrestito(2, new GregorianCalendar(2023, 05, 20));
		
		
	}
	
	
	/*
	 * METODI RICHIESTI 
	 */

	public static void aggiungiElemento(Elemento e) {
		
	    EntityManager em = emf.createEntityManager();
		
        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Exception ec) {
            em.getTransaction().rollback();
            log.error(ec.getMessage());
        } finally {
            em.close();
        }
   
	}
	
	public static void rimuoviElementoPerIsbn(Integer isbn) {
		
	    EntityManager em = emf.createEntityManager();

		Elemento e = ricercaElementoPerIsbn(isbn);
	
		try {
			em.getTransaction().begin();
			em.remove(em.contains(e) ? e : em.merge(e));
			em.getTransaction().commit();
		} catch (Exception ec) {
			em.getTransaction().rollback();
			log.error(ec.getMessage());
		} finally {
			em.close();
		}
		
	}
	
	public static Elemento ricercaElementoPerIsbn(Integer isbn) {
	    EntityManager em = emf.createEntityManager();

		try {
            em.getTransaction().begin();
            return em.find(Elemento.class, isbn);
        } finally {
            em.close();
        }
	}
	
	public static List<Elemento> ricercaElementiPerAnno(Integer anno) {
	    EntityManager em = emf.createEntityManager();
	    Query q = em.createQuery("SELECT e FROM Elemento e WHERE anno = " + anno);
        return q.getResultList();
    }
	
	public static List<Libro> ricercaLibriPerAutore(String autore) {
	    EntityManager em = emf.createEntityManager();
	    Query q = em.createQuery("SELECT l FROM Libro l WHERE lower(autore) = '" + autore.toLowerCase() + "'");
        return q.getResultList();
	}
	
	public static List<Elemento> ricercaElementiPerTitolo(String titolo) {
	    EntityManager em = emf.createEntityManager();
	    Query q = em.createQuery("SELECT e FROM Elemento e WHERE lower(titolo) LIKE '%" + titolo.toLowerCase() + "%'");
        return q.getResultList();
	}
	
	public static List<Prestito> ricercaElementiInPrestito(Integer tessera) {
	    EntityManager em = emf.createEntityManager();
	    Query q = em.createQuery("SELECT p FROM Prestito p WHERE utente_tessera = " + tessera);
        return q.getResultList();
	}
	
	public static void ricercaPrestitiScaduti(GregorianCalendar data) {
	    EntityManager em = emf.createEntityManager();
	    Query q = em.createQuery("SELECT p FROM Prestito p");
	    List<Prestito> lista = q.getResultList();
		for (Prestito p : lista) {
			if(p.getData_fine() == null && p.getData_previsione().compareTo(data.getTime()) < 0 ) {
				System.out.println(p.toString());
			}
		}
	}
	
	
	/*
	 * METODI PER FUNZIONALITA'
	 */

	public static void aggiungiUtente(Utente u) {
		
		EntityManager em = emf.createEntityManager();
		
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception ec) {
            em.getTransaction().rollback();
            log.error(ec.getMessage());
        } finally {
            em.close();
        }
   
	}
	
	public static Utente ricercaUtentePerTessera(Integer tessera) {
	    EntityManager em = emf.createEntityManager();

		try {
            em.getTransaction().begin();
            return em.find(Utente.class, tessera);
        } finally {
            em.close();
        }
	}

	public static void aggiungiPrestito(Prestito p) {
		
		EntityManager em = emf.createEntityManager();
		
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception ec) {
            em.getTransaction().rollback();
            log.error(ec.getMessage());
        } finally {
            em.close();
        }
   
	}
	
	public static void impostaFinePrestito(Integer idPrestito, GregorianCalendar dataFine) {
	    EntityManager em = emf.createEntityManager();
        Prestito p = em.find(Prestito.class, idPrestito);
        p.setData_fine(dataFine.getTime());
        
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception ec) {
            em.getTransaction().rollback();
            log.error(ec.getMessage());
        } finally {
            em.close();
        }

	}
	
    /*
     *GENERATORE CODICE ISBN 
     */
	
    public static int isbnGenerator() {
        Random rand = new Random(); 
        return rand.nextInt(999999-100000) + 100000;
    }
    
    /*
     * GENERATORE CODICE TESSERA
     */
    
    public static int codiceTessera() {
        Random rand = new Random(); 
        return rand.nextInt(9999-1000) + 1000;
    }
	
}
