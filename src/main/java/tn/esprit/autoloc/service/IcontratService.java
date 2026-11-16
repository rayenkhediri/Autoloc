package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Contrat;

import java.util.List;

public interface IcontratService {
    Contrat ajouterContrat(Contrat c);
    Contrat modifierContrat(Contrat c);
    Contrat afficherContratById(Long id);
    List<Contrat> afficherAllContrats();
    void supprimerContrat(Long id);
}
