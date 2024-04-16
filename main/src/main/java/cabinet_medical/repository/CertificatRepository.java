package cabinet_medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cabinet_medical.entity.Certificat;
import cabinet_medical.entity.Patient;
import java.util.*;
@Repository
public interface CertificatRepository extends JpaRepository<Certificat, Long> {
    Patient findByLastname(String lastName);
  List<Certificat> findByFichePatientId(Long fichePatientId);
}

