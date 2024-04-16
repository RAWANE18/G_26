package cabinet_medical.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabinet_medical.entity.Antecedant;
import cabinet_medical.entity.Patient;
import cabinet_medical.repository.AntecedantRepository;
import cabinet_medical.repository.PatientRepository;

@Service
public class AntecedantService {

    @Autowired
    private AntecedantRepository antecedantRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Antecedant saveAntecedant(String antecedantMedicaux, String antecedantChirurgicaux, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        Antecedant antecedant = new Antecedant();
        antecedant.setAntecedantMedicaux(antecedantMedicaux);
        antecedant.setAntecedantChirurgicaux(antecedantChirurgicaux);
        antecedant.setPatient(patient);
        return antecedantRepository.save(antecedant);
    }
 
    public Antecedant getAntecedantByFichePatientId(Long fichePatientId) {
        return antecedantRepository.findByFichePatientId(fichePatientId);
    }
}
