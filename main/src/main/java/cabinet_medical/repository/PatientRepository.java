package cabinet_medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cabinet_medical.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

    Patient findByLastname(String lastName);

}   