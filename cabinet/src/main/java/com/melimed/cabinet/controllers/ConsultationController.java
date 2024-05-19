package com.melimed.cabinet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.melimed.cabinet.models.Certificat;
import com.melimed.cabinet.models.Consultation;
import com.melimed.cabinet.models.Ordonnance;
import com.melimed.cabinet.services.CertificatService;
import com.melimed.cabinet.services.ConsultationService;
import com.melimed.cabinet.services.OrdonnanceService;
import com.melimed.cabinet.services.PatientService;
import com.melimed.cabinet.dtos.ConsultationDTO;

@Controller
@RequestMapping("consultation")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private OrdonnanceService ordonnanceService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private CertificatService certificatService;

    // tableau de toutes les ordonnances
    @GetMapping("/showall")
    public String showConsultationList(Model model) {
        List<Consultation> consultations = consultationService.getAllConsultations();
        model.addAttribute("consultations", consultations);
        return "packdoctor/consultation/showAll";
    }

     // tableau de toutes les consultations d'un seul patient
     @GetMapping("/showone{id}")
     public String showConsultationListByPatient(Model model,@PathVariable(name = "id") Long id) {
         List<Consultation> consultations = consultationService.getAllConsultationPatient(id);
         model.addAttribute("idPatient", id);
         model.addAttribute("consultations", consultations);
         return "packdoctor/consultation/showAll";
     }

    // show une consultation , on passe l'id d'une consult pour avoir toutes les ordonnances et certificats
    @GetMapping("/show{id}")
    public String showConsultation(Model model, @PathVariable(name = "id") Long id) {
        Consultation consultation = consultationService.getOneConsultation(id);
        List<Ordonnance> ordonnances = ordonnanceService.getAllOrdonnances();
        List<Certificat> certificats = certificatService.getAllCertificats();
        model.addAttribute("certificats", certificats);
        model.addAttribute("ordonnances", ordonnances);
        model.addAttribute("consultation", consultation);
        return "packdoctor/consultation/show";
    }

    // show the html page to create the ordonnance
    /*
     * @GetMapping("/create")
     * public String showCreatePage(Model model) {
     * ConsultationDTO consultationDTO = new ConsultationDTO();
     * List<Long> patientIds = consultationService.getAllPatientIds();
     * model.addAttribute("consultationDTO", consultationDTO);
     * model.addAttribute("patientIds", patientIds);
     * return "consultation/create";
     * }
     */
    @GetMapping("/create{id}")
    public String showCreatePage(Model model, @PathVariable(name = "id") Long id) {
        ConsultationDTO consultationDTO = new ConsultationDTO();
        // Patient patient = patientService.getPatientById(id);
        // consultationDTO.setIdPatient(id);
        model.addAttribute("consultationDTO", consultationDTO);
        // model.addAttribute("patient", patient);
        // ajouter dans lhtml just the rendering of the value

        return "packdoctor/consultation/create";
    }

    // save the data of the created ordonnance in the database
    @PostMapping("/create{id}")
    public String createConsultation(@Valid @ModelAttribute("consultationDTO") ConsultationDTO consultationDTO,
            BindingResult result, Model model,
            @PathVariable(name = "id") Long id) {

        if (result.hasErrors()) {
            return "packdoctor/consultation/create";
        }

        // consultationDTO.
        consultationDTO.setIdPatient(id);
        consultationService.createConsultation(consultationDTO);

        return "redirect:/patient/showall";
    }


    @GetMapping("/delete{id}")
    public String deleteCertificat(
            @PathVariable(name = "id") Long id) {

        consultationService.deleteConsultation(id);

        return "redirect:/consultation/showall";
    }
}