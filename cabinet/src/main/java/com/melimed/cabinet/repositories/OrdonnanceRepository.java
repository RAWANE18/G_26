package com.melimed.cabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melimed.cabinet.models.Consultation;
import com.melimed.cabinet.models.Ordonnance;
import java.util.List;
@Repository
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long>
{   public List<Ordonnance> findAllByConsultation(Consultation consultation);
 
}
