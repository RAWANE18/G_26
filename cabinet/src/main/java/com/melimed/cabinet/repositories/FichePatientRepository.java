package com.melimed.cabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melimed.cabinet.models.FichePatient;
import com.melimed.cabinet.models.Patient;

@Repository
public interface FichePatientRepository extends JpaRepository<FichePatient, Long> {
public FichePatient findByPatient(Patient patient);
}