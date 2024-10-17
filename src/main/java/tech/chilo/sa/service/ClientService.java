package tech.chilo.sa.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tech.chilo.sa.dto.ClientDTO;
import tech.chilo.sa.entities.Client;
import tech.chilo.sa.mapper.ClientDTOMapper;
import tech.chilo.sa.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClientService {

    private ClientDTOMapper clientDTOMapper;
    private final ClientRepository clientRepository;

    public ClientService(ClientDTOMapper clientDTOMapper, ClientRepository clientRepository) {
        this.clientDTOMapper = clientDTOMapper;
        this.clientRepository = clientRepository;
    }

    public void creer(Client client){
       Client clientDansLaBD = this.clientRepository.findByEmail(client.getEmail());
       if (clientDansLaBD == null){
           this.clientRepository.save(client);
       }



    }
    public Stream<ClientDTO> rechercher(){
        return this.clientRepository.findAll()

                .stream().map( clientDTOMapper);
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
