package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class IVehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepository equipementRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule afficherVehiculeById(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehicule> afficherAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public void supprimerVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule v = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable : " + idVehicule));
        Equipement eq = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Equipement introuvable : " + idEquipement));
        boolean dejaAffecte = v.getEquipements().stream()
                .anyMatch(x -> x.getIdEquipement().equals(idEquipement));
        if (!dejaAffecte) v.getEquipements().add(eq);   // owner side
        return vehiculeRepository.save(v);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule v = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable : " + idVehicule));
        v.getEquipements().removeIf(x -> x.getIdEquipement().equals(idEquipement));
        return vehiculeRepository.save(v);
    }

    @Override
    @Scheduled(initialDelay = 5, fixedRate = 60, timeUnit = TimeUnit.SECONDS)
    public void ActualiserVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        Integer nb = vehicules.size();
        System.out.println("le nombre des vehicules " + nb);
        System.out.println("date et heure " + LocalDateTime.now());
    }
}