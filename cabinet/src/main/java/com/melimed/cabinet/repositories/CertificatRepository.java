package com.melimed.cabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.melimed.cabinet.models.Certificat;
import com.melimed.cabinet.models.Patient;

import java.util.*;
@Repository
public interface CertificatRepository extends JpaRepository<Certificat, Long> {
  //  Patient findByLastname(String lastName);
  //List<Certificat> findByFichePatientId(Long fichePatientId);
  List <Certificat> findByPatient(Patient patient);
}

