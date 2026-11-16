package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;

public interface IclientService {
    Client ajouterClient(Client c);
    Client modifierClient(Client c);
    Client afficherClientById(Long id);
    List<Client> afficherAllClients();
    void supprimerClient(Long id);
}
