package cabinet_medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cabinet_medical.entity.Consultation;
import cabinet_medical.repository.ConsultationRepository;
import cabinet_medical.service.ConsultationService;

@RestController
public class ConsultationController {
      @Autowired
    private ConsultationRepository consultationrepo;
      @Autowired
    private ConsultationService consultationService;  

    @GetMapping("/")
    public String showConsultationList(Model model) {
      List<Consultation> consultations = consultationService.findAllConsultations();
      model.addAttribute("consultations", consultations);
      return "Consultations/indexconsult";
}
}
