package cabinet_medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cabinet_medical.repository.ConsultationRepository;

@RestController
public class ConsultationController {
      @Autowired
    private ConsultationRepository consultationrepo;

    
}