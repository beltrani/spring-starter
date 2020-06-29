package com.beltrani.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.beltrani.osworks.domain.model.Client;
import com.beltrani.osworks.domain.repository.ClientRepository;
import com.beltrani.osworks.domain.service.InsertClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InsertClientService insertClient; 

    @GetMapping
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);

        if (client.isPresent()){
            return ResponseEntity.ok(client.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client insert(@Valid @RequestBody Client client){
        return insertClient.save(client);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@Valid @PathVariable Long clientId, 
            @RequestBody Client client){
        
        if (!clientRepository.existsById(clientId)){
            return ResponseEntity.notFound().build();
        }   
        
        client.setId(clientId);
        client = insertClient.save(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable Long clientId){
        if(!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }
        insertClient.delete(clientId);

        return ResponseEntity.noContent().build();
    }
}