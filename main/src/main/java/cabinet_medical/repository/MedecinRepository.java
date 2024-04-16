package cabinet_medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cabinet_medical.entity.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long>{
    
}
