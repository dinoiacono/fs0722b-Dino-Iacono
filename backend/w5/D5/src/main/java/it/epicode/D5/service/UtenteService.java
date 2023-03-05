package it.epicode.D5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.D5.model.Utente;
import it.epicode.D5.repository.UtenteDaoRepo;

@Service
public class UtenteService {
	
	@Autowired UtenteDaoRepo utenteService;
	
	public void saveUtente(String n, String c, String e, String use) {
		Utente u = new Utente();
		u.setNome(n);
		u.setCognome(c);
		u.setEmail(e);
		u.setUsername(use);
		utenteService.save(u);
	}
	
	public Utente getUtenteByID(Long id) {	
		return utenteService.findById(id).get();
	}
	
	public void updateUtente(Utente u) {
		utenteService.save(u);
	}
	
	public void removeUtente(Utente u) {
		utenteService.delete(u);
	}
	
	public List<Utente> returnAllUtenti() {
		return (List<Utente>) utenteService.findAll();
	}

}
