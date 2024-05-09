package com.melimed.cabinet.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.melimed.cabinet.models.Patient;
import com.melimed.cabinet.services.PatientService;

@Controller
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    public String showPatientList(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patient/showAll";
    }

}
