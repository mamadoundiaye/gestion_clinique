package sn.modelsis.gestion_clinique.controller;

import org.springframework.web.bind.annotation.*;
import sn.modelsis.gestion_clinique.model.Medicament;
import sn.modelsis.gestion_clinique.service.MedicamentService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hopital")
public class MedicamentResource {
    private final MedicamentService MedicamentService;

    public MedicamentResource(MedicamentService MedicamentService) {
        this.MedicamentService = MedicamentService;
    }

    @GetMapping("/Medicaments")
    public List<Medicament> getAllMedicaments() {
        return MedicamentService.findAll();
    }

    @GetMapping("/Medicaments/{id}")
    public Optional<Medicament> getMedicamentById(@PathVariable("id") Long id) {
        Optional<Medicament> Medicament = MedicamentService.findOne(id);
        return Medicament;
    }
}