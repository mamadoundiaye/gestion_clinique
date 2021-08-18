package sn.modelsis.gestion_clinique.controller;

import org.springframework.web.bind.annotation.*;
import sn.modelsis.gestion_clinique.model.Consultation;
import sn.modelsis.gestion_clinique.service.ConsultationService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hopital")
public class ConsultationResource {
    private final ConsultationService ConsultationService;

    public ConsultationResource(ConsultationService ConsultationService) {
        this.ConsultationService = ConsultationService;
    }

    @GetMapping("/Consultations")
    public List<Consultation> getAllConsultations() {
        return ConsultationService.findAll();
    }

    @GetMapping("/Consultations/{id}")
    public Optional<Consultation> getConsultationById(@PathVariable("id") Long id) {
        Optional<Consultation> Consultation = ConsultationService.findOne(id);
        return Consultation;
    }
}