package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IClientServiceImpl implements IclientService {
    private final ClientRepository clientrepository;
    @Override
    public Client ajouterClient(Client c) {
        return clientrepository.save(c);
    }

    @Override
    public Client modifierClient(Client c) {
        return clientrepository.save(c);
    }

    @Override
    public Client afficherClientById(Long id) {
        return clientrepository.findById(id).orElse( null);
    }

    @Override
    public List<Client> afficherAllClients() {
        return clientrepository.findAll();
    }

    @Override
    public void supprimerClient(Long id) {
clientrepository.deleteById(id);
    }
}
