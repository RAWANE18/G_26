package com.melimed.cabinet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.melimed.cabinet.models.Patient;
import com.melimed.cabinet.services.PatientService;
import com.melimed.cabinet.dtos.PatientDTO;

@Controller
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // tableau de tout les patients

    @GetMapping("/showall")
    public String showPatientList(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patient/showAll";
    }

   @GetMapping("/showone{id}")
   public String showPatient(Model model, @PathVariable(name = "id") Long id) {
    Patient patients = patientService.getPatientById(id);
    model.addAttribute("patients", patients);
    return "patient/showAll";
}
    // show the html page to create the patient
    @GetMapping("/create")
    public String showCreatePage(Model model) {

        model.addAttribute("patientDTO", new PatientDTO());
        return "patient/create";
    }

    // save the data of the created patient in the database
    @PostMapping("/create")
    public String createPatient(@Valid @ModelAttribute PatientDTO patientDto, BindingResult result) {
        if (result.hasErrors()) {
            return "patient/create";
        }
        patientService.createPatient(patientDto);
        return "redirect:/patient";
    }

    @GetMapping("/delete{id}")
    public String deletePatient(
            @PathVariable(name = "id") Long id) {

        patientService.deletePatient(id);

        return "redirect:/patient/showall";
    }

}