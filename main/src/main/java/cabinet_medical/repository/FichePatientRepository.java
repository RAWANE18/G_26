package cabinet_medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cabinet_medical.entity.FichePatient;
import cabinet_medical.entity.Patient;

@Repository
public interface FichePatientRepository extends JpaRepository<FichePatient, Long> {

    FichePatient findByPatient(Patient patient);
 
}