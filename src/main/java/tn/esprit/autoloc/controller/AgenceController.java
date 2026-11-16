package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
@Tag(name = "gestion des agences", description = "crud")
public class AgenceController {

    private final IAgenceService agenceService;

    @Operation(summary = "ajouter agence")
    @PostMapping("/ajouterAgence")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @Operation(summary = "modifier agence")
    @PutMapping("/modifierAgence")
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @Operation(summary = "afficher agence par id")
    @GetMapping("/afficherAgenceById/{id}")
    public Agence afficherAgenceById(@PathVariable Long id) {
        return agenceService.afficherAgenceById(id);
    }

    @Operation(summary = "afficher tous les agences")
    @GetMapping("/afficherAllAgences")
    public List<Agence> afficherAllAgences() {
        return agenceService.afficherAllAgences();
    }

    @Operation(summary = "supprimer agence")
    @DeleteMapping("/supprimerAgence/{id}")
    public void supprimerAgence(@PathVariable Long id) {
        agenceService.supprimerAgence(id);
    }

    @Operation(summary = "ajouter une agence et lui affecter des vehicules")
    @PostMapping("/ajouterAgenceEtAffecterVehicules")
    public Agence ajouterAgenceEtAffecterVehicules(@RequestBody Agence agence) {
        return agenceService.ajouterAgenceEtAffecterVehicules(agence);
    }
}