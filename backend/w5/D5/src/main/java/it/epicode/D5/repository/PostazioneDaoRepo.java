package it.epicode.D5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.D5.model.Postazione;
import it.epicode.D5.model.TipoPostazione;

@Repository
public interface PostazioneDaoRepo extends JpaRepository<Postazione, Long>{

	public List<Postazione> findByTipo(TipoPostazione tipo);
	
	public List<Postazione> findByEdificioCitta(String citta);
		
}
