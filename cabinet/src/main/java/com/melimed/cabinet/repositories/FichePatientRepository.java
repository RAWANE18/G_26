package com.melimed.cabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melimed.cabinet.models.FichePatient;

@Repository
public interface FichePatientRepository extends JpaRepository<FichePatient, Long> {

}