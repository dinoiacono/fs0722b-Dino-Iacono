package com.GestioneIncendi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestioneIncendi.models.ProcessoDispositivo;

public interface ProcessoRepository extends JpaRepository<ProcessoDispositivo, Long> {

}
