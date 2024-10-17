package tech.chilo.sa.mapper;

import org.springframework.stereotype.Component;
import tech.chilo.sa.dto.ClientDTO;
import tech.chilo.sa.entities.Client;

import java.util.function.Function;

@Component
public class ClientDTOMapper implements Function<Client, ClientDTO> {
    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(client.getId(), client.getEmail(), client.getTelephone());
    }
}
