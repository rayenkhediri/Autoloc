package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
@Tag(name = "gestion des paiements", description = "crud")
public class PaiementController {

    private final IPaiementService paiementService;

    @Operation(summary = "ajouter paiement")
    @PostMapping("/ajouterPaiement")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @Operation(summary = "modifier paiement")
    @PutMapping("/modifierPaiement")
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @Operation(summary = "afficher paiement par id")
    @GetMapping("/afficherPaiementById/{id}")
    public Paiement afficherPaiementById(@PathVariable Long id) {
        return paiementService.afficherPaiementById(id);
    }

    @Operation(summary = "afficher tous les paiements")
    @GetMapping("/afficherAllPaiements")
    public List<Paiement> afficherAllPaiements() {
        return paiementService.afficherAllPaiements();
    }

    @Operation(summary = "supprimer paiement")
    @DeleteMapping("/supprimerPaiement/{id}")
    public void supprimerPaiement(@PathVariable Long id) {
        paiementService.supprimerPaiement(id);
    }
}
