package cabinet_medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cabinet_medical.entity.Ordonnance;
import java.util.*;

public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long>
{    //retrouver une liste d'ordinnances a partir de la  Consultation
    List<Ordonnance> findByConsultationId(Long idconsult);
}
