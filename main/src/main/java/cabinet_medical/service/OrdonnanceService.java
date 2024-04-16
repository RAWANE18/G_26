package cabinet_medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabinet_medical.entity.Ordonnance;
import cabinet_medical.repository.OrdonnanceRepository;

@Service
public class OrdonnanceService {
 
    @Autowired
    private OrdonnanceRepository ordonnanceRepository;

public List<Ordonnance> getOrdonnancesByFichePatientId(Long fichePatientId) {
        return ordonnanceRepository.findByFichePatientId(fichePatientId);
    }
}
