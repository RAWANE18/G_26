package com.melimed.cabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melimed.cabinet.models.Patient;
import com.melimed.cabinet.models.RDV;

import java.util.Calendar;
import java.util.List;

@Repository
public interface RdvRepository extends JpaRepository<RDV, Long>{
public List <RDV> findAllByPatient(Patient patient); 
public List <RDV> findAllByDate(Calendar date);
}
