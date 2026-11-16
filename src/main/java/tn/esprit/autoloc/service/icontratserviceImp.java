package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class icontratserviceImp implements IcontratService {
private final ContratRepository contratrepository;
    @Override
    public Contrat ajouterContrat(Contrat c) {
        return contratrepository.save(c);
    }

    @Override
    public Contrat modifierContrat(Contrat c) {
        return contratrepository.save(c);
    }

    @Override
    public Contrat afficherContratById(Long id) {
        return contratrepository.findById(id).orElse(null);
    }

    @Override
    public List<Contrat> afficherAllContrats() {
        return contratrepository.findAll();
    }

    @Override
    public void supprimerContrat(Long id) {
        contratrepository.deleteById(id);
    }
}


