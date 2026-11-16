package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IcontratService;

import java.util.List;

@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
@Tag(name = "gestion des contrats", description = "crud")
public class ContratController {

    private final IcontratService contratService;

    @Operation(summary = "ajouter contrat")
    @PostMapping("/ajouterContrat")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @Operation(summary = "modifier contrat")
    @PutMapping("/modifierContrat")
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @Operation(summary = "afficher contrat par id")
    @GetMapping("/afficherContratById/{id}")
    public Contrat afficherContratById(@PathVariable Long id) {
        return contratService.afficherContratById(id);
    }

    @Operation(summary = "afficher tous les contrats")
    @GetMapping("/afficherAllContrats")
    public List<Contrat> afficherAllContrats() {
        return contratService.afficherAllContrats();
    }

    @Operation(summary = "supprimer contrat")
    @DeleteMapping("/supprimerContrat/{id}")
    public void supprimerContrat(@PathVariable Long id) {
        contratService.supprimerContrat(id);
    }
}
