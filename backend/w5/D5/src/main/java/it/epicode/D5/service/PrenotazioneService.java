package it.epicode.D5.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.D5.model.*;
import it.epicode.D5.repository.PrenotazioneDaoRepo;

@Service
public class PrenotazioneService {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	@Autowired PrenotazioneDaoRepo prenotazioneService;

	
	public Prenotazione getPrenotazioneByID(Long id) {	
		return prenotazioneService.findById(id).get();
	}
	
	public void updatePrenotazione(Prenotazione p) {
		prenotazioneService.save(p);
	}
	
	public void removePrenotazione(Prenotazione p) {
		prenotazioneService.delete(p);
	}
	
	public List<Prenotazione> getPrenotazioneByPostazione(Postazione postazione) {
		return (List<Prenotazione>) prenotazioneService.findByPostazione(postazione);
	}
	
	public void salvaPrenotazione(Utente u, Postazione pos, String data, int occupanti) {
		
		List<Prenotazione> verifica = new ArrayList<Prenotazione>();
		List<Prenotazione> prenotazioni = getPrenotazioneByPostazione(pos);
		
		Calendar cal = Calendar.getInstance();  
        try{  
           cal.setTime(sdf.parse(data));  
        }catch(ParseException e){  
            e.printStackTrace();  
        }
        
        
        prenotazioni.forEach(p -> {
        	if(cal.getTime().compareTo(p.getDataPrenotazione()) == 0 || u == p.getUtente()) {
        		verifica.add(p);
        	}
        });
        
		if(verifica.size() == 0 && occupanti <= pos.getMaxUtenti()) {
			Prenotazione pre = new Prenotazione();

			pre.setPostazione(pos);
			pre.setUtente(u);
			pre.setDataPrenotazione(cal.getTime());
			cal.add(Calendar.DAY_OF_MONTH, 1); 
			pre.setDataScadenza(cal.getTime());
			
			prenotazioneService.save(pre);
		} else {
			if(occupanti > pos.getMaxUtenti()) {
				System.out.println("La Postazione non ha abbastanza posti per questa prenotazione!");
			}else {
				System.out.println("Postazione Non Disponibile!");
			}
		}
	}
}
