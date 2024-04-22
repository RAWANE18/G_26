package cabinet_medical.controller;

import cabinet_medical.dto.PatientDTO;
import cabinet_medical.entity.Patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import cabinet_medical.service.PatientService;
import jakarta.validation.Valid;




@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/")
  public String showPatientList(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "Patients/indexpatient";
     }
//show the html page to create the patient
   @GetMapping("/create")
public String showCreatePage(Model model) {
    PatientDTO patientDTO = patientService.createPatientDTO();
    model.addAttribute("patientDTO", patientDTO);
    return "patients/createpatient";
}

//save the data of the created patient in the database
@PostMapping("/create")

public String createPatient(@Valid @ModelAttribute PatientDTO patientDto, BindingResult result) {
    if (result.hasErrors()) {
        return "create-patient";
    }
    patientService.createPatient(patientDto);
    return "redirect:/patients";
}

                                    
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

   

    @GetMapping("/name/{name}")
    public Patient getPatientByName(@PathVariable String name) {
        return patientService.getPatientByName(name);
    }

    @PutMapping("/{id}")
    public Patient updatePatientName(@PathVariable Long id, @RequestBody String patient) {
        return patientService.updatePatientName(id, patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
    @GetMapping("/update")
    public String showEditPage(Model model, @RequestParam Long id) {
        try {
            Patient patient = patientService.getPatientById(id);
            model.addAttribute("patient", patient);

            PatientDTO patientDTO = new PatientDTO();
            patientDTO.setFirstname(patient.getFirstname());
            patientDTO.setAdress(patient.getAdress());
            patientDTO.setLastname(patient.getLastname());
            patientDTO.setBirthdate(patient.getBirthdate());
            patientDTO.setNumtel(patient.getNumtel());
            patientDTO.setEmail(patient.getEmail());
            patientDTO.setGender(patient.getGender()); 
            model.addAttribute("patientDTO", patientDTO);

            return "products/EditProduct";
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            return "redirect:/products";
        }
    }
}

