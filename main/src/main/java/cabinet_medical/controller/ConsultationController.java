package cabinet_medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cabinet_medical.repository.ConsultationRepository;

@RestController
public class ConsultationController {
      @Autowired
    private ConsultationRepository consultationrepo;

    @GetMapping("")
    public String showConsultationList(Model model) {
      List<Consultation> consultations = ConsultationService.findAllConsultations();
      model.addAttribute("consultations", consultations);
      return "Consultations/indexconsult";
}
}
