package cabinet_medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cabinet_medical.entity.Certificat;
import cabinet_medical.entity.Consultation;
import cabinet_medical.entity.Ordonnance;
import cabinet_medical.entity.Patient;
import cabinet_medical.repository.ConsultationRepository;

public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;
    
    @Autowired
    private PatientService patientService;

    @Autowired
    private OrdonnanceService ordonnanceService;

    @Autowired
    private CertificatService certificatService;


    public Consultation findById(Long id) {
        return consultationRepository.findById(id).orElseThrow(() -> new RuntimeException("Consultation not found"));
    }
    public  List<Consultation> findAllConsultations() {
        return consultationRepository.findAll();
    }

   //save a consultaion
    public Consultation save(Consultation consultation) {
        Patient patient = consultation.getPatient();
        patient = patientService.addPatient(patient);
        consultation.setPatient(patient);
        return consultationRepository.save(consultation);
    }

    //ajouter certificat a Consultation
public Consultation addCertificatToconsultation(Long idConsultation, Certificat certificat) {
   Consultation consultation= findById(idConsultation);
    certificat.setConsultation(consultation);
    consultation.addCertificat(certificat);
    consultationRepository.save(consultation);
    return consultation;
}

//recuperer  fiche patient avec ordonances et certificats,
public Consultation getFichePatientWithAssociations(Long idconsult) {
    Consultation consultation = findById(idconsult);
    consultation.setOrdonnances(ordonnanceService.getOrdonnancesByConsultationId(idconsult));
    consultation.setCertificats(certificatService.getCertificatsByConsultationId(idconsult));
    return consultation;
}

//rajouter une ordonnance a la consultation
public Consultation addOrdonnanceToConsultationS(Long idConsultation, Ordonnance ordonnance) {
    Consultation consultation = findById(idConsultation);
    ordonnance.setConsultation(consultation);
    consultation.addOrdonnance(ordonnance);
    consultationRepository.save(consultation);
    return consultation;
}
//rajouter certificat a la consultation
public Consultation addCertificatToConsultationS(Long idConsultation, Certificat certificat) {
    Consultation consultation = findById(idConsultation);
    certificat.setConsultation(consultation);
    consultation.addCertificat(certificat);
    consultationRepository.save(consultation);
    return consultation;
}
}
