package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
@Tag(name = "gestion des maintenances", description = "crud")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @Operation(summary = "ajouter maintenance")
    @PostMapping("/ajouterMaintenance")
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @Operation(summary = "modifier maintenance")
    @PutMapping("/modifierMaintenance")
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @Operation(summary = "afficher maintenance par id")
    @GetMapping("/afficherMaintenanceById/{id}")
    public Maintenance afficherMaintenanceById(@PathVariable Long id) {
        return maintenanceService.afficherMaintenanceById(id);
    }

    @Operation(summary = "afficher tous les maintenances")
    @GetMapping("/afficherAllMaintenances")
    public List<Maintenance> afficherAllMaintenances() {
        return maintenanceService.afficherAllMaintenances();
    }

    @Operation(summary = "supprimer maintenance")
    @DeleteMapping("/supprimerMaintenance/{id}")
    public void supprimerMaintenance(@PathVariable Long id) {
        maintenanceService.supprimerMaintenance(id);
    }
}
