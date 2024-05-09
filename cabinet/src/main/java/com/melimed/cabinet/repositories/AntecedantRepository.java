package com.melimed.cabinet.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.melimed.cabinet.models.Antecedant;



@Repository
public interface AntecedantRepository extends JpaRepository<Antecedant, Long> {
   
}
