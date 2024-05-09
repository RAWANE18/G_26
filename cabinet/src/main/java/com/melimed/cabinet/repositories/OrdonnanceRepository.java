package com.melimed.cabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melimed.cabinet.models.Ordonnance;

@Repository
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long>
{
 
}
