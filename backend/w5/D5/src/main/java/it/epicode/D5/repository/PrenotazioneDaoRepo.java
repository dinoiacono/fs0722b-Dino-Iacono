package it.epicode.D5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.D5.model.Prenotazione;

@Repository
public interface PrenotazioneDaoRepo extends JpaRepository<Prenotazione, Long>{

}
