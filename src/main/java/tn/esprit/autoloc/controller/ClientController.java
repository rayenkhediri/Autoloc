package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IclientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Tag(name = "gestion des clients", description = "crud")
public class ClientController {

    private final IclientService clientService;

    @Operation(summary = "ajouter client")
    @PostMapping("/ajouterClient")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @Operation(summary = "modifier client")
    @PutMapping("/modifierClient")
    public Client modifierClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @Operation(summary = "afficher client par id")
    @GetMapping("/afficherClientById/{id}")
    public Client afficherClientById(@PathVariable Long id) {
        return clientService.afficherClientById(id);
    }

    @Operation(summary = "afficher tous les clients")
    @GetMapping("/afficherAllClients")
    public List<Client> afficherAllClients() {
        return clientService.afficherAllClients();
    }

    @Operation(summary = "supprimer client")
    @DeleteMapping("/supprimerClient/{id}")
    public void supprimerClient(@PathVariable Long id) {
        clientService.supprimerClient(id);
    }
}
