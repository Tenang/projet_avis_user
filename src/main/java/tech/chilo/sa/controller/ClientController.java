package tech.chilo.sa.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.chilo.sa.dto.ClientDTO;
import tech.chilo.sa.dto.ErrorEntity;
import tech.chilo.sa.entities.Client;
import tech.chilo.sa.service.ClientService;

import java.util.List;
import java.util.stream.Stream;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "client" )
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Client client){
        this.clientService.creer(client);
    }
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Stream<ClientDTO> rechercher(){
        return this.clientService.rechercher();
    }
    @GetMapping(path = "{id}",produces = APPLICATION_JSON_VALUE)
    //  public ResponseEntity lire(@PathVariable int id){
    public Client lire(@PathVariable int id){

            return this.clientService.lire(id);
        /* 1er facon de gerer les exceptions
        try {
            Client client = this.clientService.lire(id);
           return ResponseEntity.ok(client);
        }catch (EntityNotFoundException exception){
           return ResponseEntity.status(BAD_REQUEST).body(new ErrorEntity(null, exception.getMessage()));
        }*/

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id,  @RequestBody Client client){
        this.clientService.modifier(id,client);
    }

   /* 2e maniere de gerer les erreurs
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({EntityNotFoundException.class})
    public ErrorEntity handleException(EntityNotFoundException exception){
        return new ErrorEntity(null , exception.getMessage());
    }*/
}
