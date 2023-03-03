package it.epicode.D5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.D5.model.Utente;
import it.epicode.D5.repository.UtenteDaoRepo;

@Service
public class UtenteService {
	
	@Autowired UtenteDaoRepo utenteService;
	
	public void saveUtente(String nome, String cognome, String email, String username) {
		Utente u = new Utente();
		u.setNome(nome);
		u.setCognome(cognome);
		u.setEmail(email);
		u.setUsername(username);
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

}
