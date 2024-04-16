package cabinet_medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cabinet_medical.service.CertificatService;

@RestController
@RequestMapping("/certificats")
public class CertificatController {

    @Autowired
    private CertificatService certificatService;

    @PostMapping("/save")
    public ResponseEntity<String> sauvegarderCertificat(@RequestParam String contenu, @RequestParam String lastName) {
        certificatService.sauvegarderCertificat(contenu, lastName);
        return ResponseEntity.ok("Certificat saved successfully.");
    }
}

