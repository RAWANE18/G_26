package com.melimed.cabinet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;

import com.melimed.cabinet.models.Certificat;
import com.melimed.cabinet.models.Consultation;
import com.melimed.cabinet.models.Patient;
import com.melimed.cabinet.services.CertificatService;
import com.melimed.cabinet.services.ConsultationService;
import com.melimed.cabinet.services.PatientService;
import com.melimed.cabinet.dtos.CertificatDTO;


@Controller
@RequestMapping("certificat")
public class CertificatController {

    @Autowired
    private CertificatService certificatService;
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private PatientService patientService;
 
    // tableau de toutes les certificats
     @GetMapping("/showall")
     public String showOrdonnanceList(Model model) {
         List<Certificat> certificats = certificatService.getAllCertificats();
         model.addAttribute("certificats", certificats);
         return "certificat/showAll";
     }

   //show the html page to create the certif
  @GetMapping("/create{id}")
  public String showCreatePage(Model model, @PathVariable(name = "id") Long id) {

      CertificatDTO certificatDTO = new CertificatDTO();
      Consultation consultation = consultationService.getById(id);
      certificatDTO.setIdconsultation(consultation.getIdConsultation());
      Patient patient = patientService.getPatientById(consultation.getPatient().getIdPatient());
      model.addAttribute("certificatDTO", certificatDTO);
      model.addAttribute("patient", patient);
      model.addAttribute("consultation", consultation);
      return "certificat/create";
  }

// save the data of the created certificat in the database
@PostMapping("/create{id}")
public String createCertificat(
        @Valid @ModelAttribute("certificatDTO") CertificatDTO certificatDTO,
        @PathVariable(name = "id") Long idConsult,
        BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "certificat/create";
    }
    certificatDTO.setIdconsultation(idConsult);

    certificatService.createCertificat(certificatDTO);
    return "redirect:/patient/showall";
}

@GetMapping("/delete{id}")
    public String deleteCertificat(
            @PathVariable(name = "id") Long id) {

        certificatService.deleteCertificat(id);

        return "redirect:/certificat/showall";
    }
}
