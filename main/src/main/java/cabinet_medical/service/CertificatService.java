package cabinet_medical.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cabinet_medical.entity.Certificat;
import cabinet_medical.entity.Patient;
import cabinet_medical.repository.CertificatRepository;
import cabinet_medical.repository.PatientRepository;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class CertificatService {

    @Autowired
    private CertificatRepository certificatRepository;

    @Autowired
    private PatientRepository patientsRepository; 

    public void sauvegarderCertificat(String contenu, String lastName) {
        Patient patient = patientsRepository.findByLastname(lastName);
        if (patient != null) {
            Certificat certificat = new Certificat();
            certificat.setContenu(contenu);
            certificat.setDateDelivrance(new Date());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, 3);
            certificat.setDateExpiration(calendar.getTime());

            certificat.setPatient(patient);

            certificatRepository.save(certificat);
        }
    }
    
    public List<Certificat> getCertificatsByConsultationId(Long idconsult) {
        return certificatRepository.findByConsultationId(idconsult);
    }

}
