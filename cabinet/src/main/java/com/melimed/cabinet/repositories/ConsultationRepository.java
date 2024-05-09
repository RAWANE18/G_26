package com.melimed.cabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melimed.cabinet.models.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{

}
