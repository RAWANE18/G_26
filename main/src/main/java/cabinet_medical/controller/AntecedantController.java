package cabinet_medical.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cabinet_medical.entity.Antecedant;
import cabinet_medical.service.AntecedantService;

@RestController
public class AntecedantController {

    @Autowired
    private AntecedantService antecedantService;

    @PostMapping("/saveAntecedant")
    public String saveAntecedant(@RequestParam("AntecedantMedicaux") String antecedantMedicaux,
                                 @RequestParam("AntecedantChirurgicaux") String antecedantChirurgicaux,
                                 @RequestParam("patientId") Long patientId) {
        Antecedant antecedant = antecedantService.saveAntecedant(antecedantMedicaux, antecedantChirurgicaux, patientId);
        return "Antecedant saved with id " + antecedant.getId();
    }
}

