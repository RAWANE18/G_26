package cabinet_medical.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cabinet_medical.repository.MedecinRepository;



@RestController
@RequestMapping("/Medecin")
public class MedecinController {
    
    @Autowired
    private MedecinRepository medrepo;
    
}
