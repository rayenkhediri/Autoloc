package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
@Tag(name = "gestion des vehicules", description = "crud")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @Operation(summary = "ajouter vehicule")
    @PostMapping("/ajouterVehicule")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @Operation(summary = "modifier vehicule")
    @PutMapping("/modifierVehicule")
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @Operation(summary = "afficher vehicule par id")
    @GetMapping("/afficherVehiculeById/{id}")
    public Vehicule afficherVehiculeById(@PathVariable Long id) {
        return vehiculeService.afficherVehiculeById(id);
    }

    @Operation(summary = "afficher tous les vehicules")
    @GetMapping("/afficherAllVehicules")
    public List<Vehicule> afficherAllVehicules() {
        return vehiculeService.afficherAllVehicules();
    }

    @Operation(summary = "supprimer vehicule")
    @DeleteMapping("/supprimerVehicule/{id}")
    public void supprimerVehicule(@PathVariable Long id) {
        vehiculeService.supprimerVehicule(id);
    }

    @Operation(summary = "affecter un equipement a un vehicule")
    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return vehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    @Operation(summary = "desaffecter un equipement d'un vehicule")
    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }
}