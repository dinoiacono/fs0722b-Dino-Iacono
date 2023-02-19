package main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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

		//mioUtente.setEmail("mario.rossi@example.com");
		//modificaUtente(mioUtente);
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
