package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
@Tag(name = "gestion des equipements", description = "crud")
public class EquipementController {

    private final IEquipementService equipementService;

    @Operation(summary = "ajouter equipement")
    @PostMapping("/ajouterEquipement")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @Operation(summary = "modifier equipement")
    @PutMapping("/modifierEquipement")
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @Operation(summary = "afficher equipement par id")
    @GetMapping("/afficherEquipementById/{id}")
    public Equipement afficherEquipementById(@PathVariable Long id) {
        return equipementService.afficherEquipementById(id);
    }

    @Operation(summary = "afficher tous les equipements")
    @GetMapping("/afficherAllEquipements")
    public List<Equipement> afficherAllEquipements() {
        return equipementService.afficherAllEquipements();
    }

    @Operation(summary = "supprimer equipement")
    @DeleteMapping("/supprimerEquipement/{id}")
    public void supprimerEquipement(@PathVariable Long id) {
        equipementService.supprimerEquipement(id);
    }
}
