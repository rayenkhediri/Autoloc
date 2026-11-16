package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
@Tag(name = "gestion des employes", description = "crud")
public class EmployeController {

    private final IEmployeService employeService;

    @Operation(summary = "ajouter employe")
    @PostMapping("/ajouterEmploye")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @Operation(summary = "modifier employe")
    @PutMapping("/modifierEmploye")
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @Operation(summary = "afficher employe par id")
    @GetMapping("/afficherEmployeById/{id}")
    public Employe afficherEmployeById(@PathVariable Long id) {
        return employeService.afficherEmployeById(id);
    }

    @Operation(summary = "afficher tous les employes")
    @GetMapping("/afficherAllEmployes")
    public List<Employe> afficherAllEmployes() {
        return employeService.afficherAllEmployes();
    }

    @Operation(summary = "supprimer employe")
    @DeleteMapping("/supprimerEmploye/{id}")
    public void supprimerEmploye(@PathVariable Long id) {
        employeService.supprimerEmploye(id);
    }
    @PutMapping("/desaffecterEmploye/{idEmploye}")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }

    @PutMapping("/affecterEmploye/{idEmploye}/{idAgence}")
    public Employe affecterEmploye(@PathVariable Long idEmploye, @PathVariable Long idAgence) {
        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}
