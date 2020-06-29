package com.beltrani.osworks.domain.service;

import com.beltrani.osworks.domain.exception.BusinessException;
import com.beltrani.osworks.domain.model.Client;
import com.beltrani.osworks.domain.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {

        Client existentClient = clientRepository.findByEmail(client.getEmail());

        if(existentClient != null && !existentClient.equals(client)){   
            throw new BusinessException("Já existe um cliente com este email.");
        }
        return clientRepository.save(client);
    }

    public void delete(Long clienteId) {
        clientRepository.deleteById(clienteId);
    }
}