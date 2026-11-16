package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IAgenceServiceImpl implements IAgenceService {

    private final AgenceRepository agenceRepository;
    private final VehiculeRepository vehiculeRepository;

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence modifierAgence(Agence agence) {
        return agenceRepository.findById(agence.getIdAgence()).map(existingAgence -> {
            if (agence.getNom() != null) existingAgence.setNom(agence.getNom());
            if (agence.getVille() != null) existingAgence.setVille(agence.getVille());
            if (agence.getAdresse() != null) existingAgence.setAdresse(agence.getAdresse());
            if (agence.getTelephone() != null) existingAgence.setTelephone(agence.getTelephone());
            return agenceRepository.save(existingAgence);
        }).orElseThrow(() -> new RuntimeException("Agence not found with id: " + agence.getIdAgence()));
    }

    @Override
    public Agence afficherAgenceById(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Agence> afficherAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public void supprimerAgence(Long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        List<Vehicule> vehicules = agence.getVehicules() == null
                ? new ArrayList<>() : new ArrayList<>(agence.getVehicules());
        agence.setVehicules(new ArrayList<>());

        Agence saved = agenceRepository.save(agence);   // 1. enregistrer l'agence

        for (Vehicule v : vehicules) {
            v.setAgence(saved);                         // 2. affecter chaque véhicule
            saved.getVehicules().add(v);
        }
        vehiculeRepository.saveAll(vehicules);          // 3. enregistrer les véhicules
        return saved;
    }
}