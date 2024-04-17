package cabinet_medical.service;

public class ConsultationService   {
    @Autowired
    private ConsutlationRepository consutlationRepository;

    @Autowired
    private OrdonnanceService ordonnanceService;

    @Autowired
    private CertificatService certificatService;


    //ajouter certificat a Consultation
public Consultation addCertificatToconsultation(Long idConsultation, Certificat certificat) {
   Consultation consultation= findById(idConsultation);
    certificat.setConsultation(consultation);
    consultaiton.addCertificat(certificat);
    ConsultationRepository.save(consultaiton);
    return consutlation;

}
