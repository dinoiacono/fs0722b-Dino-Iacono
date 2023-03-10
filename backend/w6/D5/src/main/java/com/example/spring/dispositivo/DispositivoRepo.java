package com.example.spring.dispositivo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepo extends JpaRepository<Dispositivo, Long> {

}
