package cabinet_medical.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import cabinet_medical.entity.Consultation;


public interface ConsultationRepository extends JpaRepository<Consultation, Long>{

}
