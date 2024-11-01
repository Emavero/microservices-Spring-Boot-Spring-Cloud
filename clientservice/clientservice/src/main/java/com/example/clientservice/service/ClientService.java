package com.example.clientservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clientservice.entity.Client;
import com.example.clientservice.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;


    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(Long id){
        return clientRepository.findById(id).orElse(null);
    }

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }

}
