package cabinet_medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cabinet_medical.entity.Ordonnance;
import java.util.*;

public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long>
{
    List<Ordonnance> findByFichePatientId(Long fichePatientId);
}
