package sn.modelsis.gestion_clinique.controller;

import org.springframework.web.bind.annotation.*;
import sn.modelsis.gestion_clinique.model.Patient;
import sn.modelsis.gestion_clinique.service.PatientService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hopital")
public class PatientResource {
    private final PatientService PatientService;

    public PatientResource(PatientService PatientService) {
        this.PatientService = PatientService;
    }

    @GetMapping("/Patients")
    public List<Patient> getAllPatients() {
        return PatientService.findAll();
    }

    @GetMapping("/Patients/{id}")
    public Optional<Patient> getPatientById(@PathVariable("id") Long id) {
        Optional<Patient> Patient = PatientService.findOne(id);
        return Patient;
    }
}