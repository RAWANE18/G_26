package com.melimed.cabinet.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.melimed.cabinet.repositories.OrdonnanceRepository;
import com.melimed.cabinet.repositories.PatientRepository;
import com.melimed.cabinet.repositories.ConsultationRepository;
import com.melimed.cabinet.models.Consultation;
import com.melimed.cabinet.models.Ordonnance;
import com.melimed.cabinet.dtos.OrdonnanceDTO;
import com.melimed.cabinet.models.Patient;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrdonnanceService {
    private OrdonnanceRepository repo;
    private PatientRepository patientrepo;
    private ConsultationRepository consultrepo;

    @Autowired
    public void setRepo(ConsultationRepository consultrepo, OrdonnanceRepository repo, PatientRepository patientrepo) {
        this.repo = repo;
        this.patientrepo = patientrepo;
        this.consultrepo = consultrepo;
    }

    // show all ordonnances
    public List<Ordonnance> getAllOrdonnances() {
        return repo.findAll();
    }
    //toute les ordos d'un patient
    public List<Ordonnance> getAllOrdonnancesByPatient(Patient patient){
        return repo.findAllByPatient(patient);
    }
    // create une ordonnance
    public Ordonnance createOrdonnance(OrdonnanceDTO ordonnanceDto) {
        Ordonnance ordonnance = new Ordonnance();
        ordonnance.setContenu(ordonnanceDto.getContenu());
        ordonnance.setConsultation(consultrepo.findByIdConsultation(ordonnanceDto.getIdconsultation()));

        // Using the PatientService to fetch the patient
        // Patient patient = new Patient();
        ordonnance.setPatient(ordonnance.getConsultation().getPatient());

        return repo.save(ordonnance);

    }

    public OrdonnanceDTO createOrdonnanceDTO() {
        OrdonnanceDTO ordonnanceDTO = new OrdonnanceDTO();
        return ordonnanceDTO;
    }

    // fetch all ordonnances by idconsult
    public List<Ordonnance> getAllByIdConsult(Consultation consultation) {
        return repo.findAllByConsultation(consultation);
    }

    // Fetch all patient IDs
    public List<Long> getAllPatientIds() {
        return patientrepo.findAll().stream()
                .map(Patient::getIdPatient)
                .collect(Collectors.toList());
    }

    // suppression
    public void deleteOrdonnace(Long id) {
        repo.deleteById(id);
    }

}
