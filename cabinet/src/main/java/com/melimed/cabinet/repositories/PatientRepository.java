package com.melimed.cabinet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melimed.cabinet.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
       
   public Patient findByIdPatient(Long id) ;

        
    
   
}   