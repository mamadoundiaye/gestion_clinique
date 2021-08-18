package sn.modelsis.gestion_clinique.controller;

import org.springframework.web.bind.annotation.*;
import sn.modelsis.gestion_clinique.model.Medecin;
import sn.modelsis.gestion_clinique.service.MedecinService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hopital")
public class MedecinResource {
    private final MedecinService MedecinService;

    public MedecinResource(MedecinService MedecinService) {
        this.MedecinService = MedecinService;
    }

    @GetMapping("/Medecins")
    public List<Medecin> getAllMedecins() {
        return MedecinService.findAll();
    }

    @GetMapping("/Medecins/{id}")
    public Optional<Medecin> getMedecinById(@PathVariable("id") Long id) {
        Optional<Medecin> Medecin = MedecinService.findOne(id);
        return Medecin;
    }
}