package com.melimed.cabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.melimed.cabinet.models.Medecin;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long>{
    
}
