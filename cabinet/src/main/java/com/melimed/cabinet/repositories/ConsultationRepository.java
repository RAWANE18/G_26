package com.melimed.cabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.melimed.cabinet.models.Patient;

import com.melimed.cabinet.models.Consultation;
import java.util.List;
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
public List<Consultation> findAllByPatient(Patient patient);
}
