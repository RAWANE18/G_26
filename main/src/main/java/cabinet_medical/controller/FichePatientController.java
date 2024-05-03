package cabinet_medical.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cabinet_medical.entity.FichePatient;
import cabinet_medical.service.FichePatientService;

@RestController
public class FichePatientController {

    @Autowired
    private FichePatientService fichePatientService;

    @PostMapping("/fichePatient")
    public FichePatient createFichePatient(@RequestBody FichePatient fichePatient) {
        return fichePatientService.save(fichePatient);
    }

    @GetMapping("/fichePatients")
    public List<FichePatient> getAllFichePatients() {
        return fichePatientService.findAll();
    }

    @GetMapping("/fichePatient/{id}")
    public FichePatient getFichePatientById(@PathVariable Long id) {
        return fichePatientService.findById(id);
    }

    @DeleteMapping("/fichePatient/{id}")
    public void deleteFichePatient(@PathVariable Long id) {
        fichePatientService.delete(id);
    }

  
}

