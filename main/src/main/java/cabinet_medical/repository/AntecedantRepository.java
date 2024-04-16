package cabinet_medical.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cabinet_medical.entity.Antecedant;


@Repository
public interface AntecedantRepository extends JpaRepository<Antecedant, Long> {
    Antecedant findByFichePatientId(Long fichePatientId);
}
