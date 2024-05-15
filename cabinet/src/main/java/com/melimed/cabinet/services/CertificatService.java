package com.melimed.cabinet.services;
import org.springframework.beans.factory.annotation.Autowired;
import com.melimed.cabinet.repositories.CertificatRepository;
import com.melimed.cabinet.repositories.PatientRepository;
import com.melimed.cabinet.repositories.ConsultationRepository;
import com.melimed.cabinet.models.Certificat;
import com.melimed.cabinet.dtos.CertificatDTO;
import com.melimed.cabinet.models.Patient;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CertificatService {
    private CertificatRepository repo;
    private PatientRepository patientrepo;
    private ConsultationRepository consultrepo;
    @Autowired
    public void setRepo(ConsultationRepository consultrepo,CertificatRepository repo, PatientRepository patientrepo) {
        this.repo = repo;
        this.patientrepo=patientrepo;
        this.consultrepo=consultrepo;
    }
    //show all certificats
  public List<Certificat> getAllCertificats() {
    return repo.findAll();
}

 // create une ordonnance
 public Certificat createCertificat(CertificatDTO certificatDto) {
    Certificat certificat = new Certificat();
    certificat.setContenu(certificatDto.getContenu());
    certificat.setIdconsultation(consultrepo.findByIdConsultation(certificatDto.getIdconsultation()));

    // Using the PatientService to fetch the patient
    // Patient patient = new Patient();
    certificat.setPatient(certificat.getIdconsultation().getPatient());

    return repo.save(certificat);

}

public CertificatDTO createCertificatDTO() {
    CertificatDTO certificatDTO= new CertificatDTO();
    return certificatDTO;
}

// Fetch all patient IDs
public List<Long> getAllPatientIds() {
    return patientrepo.findAll().stream()
        .map(Patient::getIdPatient)
        .collect(Collectors.toList());
}
 //supprimer un certificat
 public void deleteCertificat(Long id) {
    repo.deleteById(id);
}
}
