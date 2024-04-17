package cabinet_medical.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabinet_medical.entity.Antecedant;
import cabinet_medical.entity.Certificat;
import cabinet_medical.entity.FichePatient;
import cabinet_medical.entity.Ordonnance;
import cabinet_medical.entity.Patient;
import cabinet_medical.repository.FichePatientRepository;

@Service
public class FichePatientService {

    @Autowired
    private FichePatientRepository fichePatientRepository;

    @Autowired
    private PatientService patientService;

   
    @Autowired
    private AntecedantService antecedantService;

    public FichePatient findById(Long id) {
        return fichePatientRepository.findById(id).orElseThrow(() -> new RuntimeException("Fiche patient not found"));
    }


    public FichePatient save(FichePatient fichePatient) {
        Patient patient = fichePatient.getPatient();
        patient = patientService.addPatient(patient);
        fichePatient.setPatient(patient);
        return fichePatientRepository.save(fichePatient);
    }

    public FichePatient findByPatient(Patient patient) {
        return fichePatientRepository.findByPatient(patient);
    }

    public List<FichePatient> findAll() {
        return fichePatientRepository.findAll();
    }

    public void delete(Long id) {
        fichePatientRepository.deleteById(id);
    }

   

    //recuperer  fiche patient avec ordonances , certificats, et antecedants
public FichePatient getFichePatientWithAssociations(Long fichePatientId) {
    FichePatient fichePatient = findById(fichePatientId);
    fichePatient.setOrdonnances(ordonnanceService.getOrdonnancesByFichePatientId(fichePatientId));
    fichePatient.setAntecedant(antecedantService.getAntecedantByFichePatientId(fichePatientId));
    fichePatient.setCertificats(certificatService.getCertificatsByFichePatientId(fichePatientId));
    return fichePatient;
}


//rajouter une ordonnance a la fiche patient
public FichePatient addOrdonnanceToFichePatient(Long fichePatientId, Ordonnance ordonnance) {
    FichePatient fichePatient = findById(fichePatientId);
    ordonnance.setFichePatient(fichePatient);
    fichePatient.addOrdonnance(ordonnance);
    fichePatientRepository.save(fichePatient);
    return fichePatient;
}
//ajouter antecedant a fiche patient
public FichePatient addAntecedantToFichePatient(Long fichePatientId, Antecedant antecedant) {
    FichePatient fichePatient = findById(fichePatientId);
    antecedant.setFichePatient(fichePatient);
    fichePatient.addAntecedant(antecedant);
    fichePatientRepository.save(fichePatient);
    return fichePatient;
}

}



}
