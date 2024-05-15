package com.melimed.cabinet.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.melimed.cabinet.models.Antecedant;
import com.melimed.cabinet.models.Patient;



@Repository
public interface AntecedantRepository extends JpaRepository<Antecedant, Long> {
   public Antecedant findByPatient(Patient patient);
}
