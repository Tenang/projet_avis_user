package tech.chilo.sa.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tech.chilo.sa.entities.Client;
import tech.chilo.sa.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client){
       Client clientDansLaBD = this.clientRepository.findByEmail(client.getEmail());
       if (clientDansLaBD == null){
           this.clientRepository.save(client);
       }



    }
    public List<Client> rechercher(){
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        ///return optionalClient.orElse(null);
        return optionalClient.orElseThrow(
                () -> new EntityNotFoundException("Aucun client n'existe avec cet id")
        );
    }

    public Client LireOUCreer(Client clientAcreer) {
        Client clientDansLaBD = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if (clientDansLaBD == null){
            clientDansLaBD = this.clientRepository.save(clientAcreer);
        }
        return  clientDansLaBD;

    }

    public void modifier(int id, Client client) {
        Client clientDansLaBD= this.lire(id);

        if (clientDansLaBD.getId() == client.getId()){

            clientDansLaBD.setEmail(client.getEmail());
            clientDansLaBD.setTelephone(client.getTelephone());
            this.clientRepository.save(clientDansLaBD);

        }
    }
}
