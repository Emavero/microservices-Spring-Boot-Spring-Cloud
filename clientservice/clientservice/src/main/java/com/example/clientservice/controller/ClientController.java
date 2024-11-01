package com.example.clientservice.controller;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientservice.dto.ClientDTO;
import com.example.clientservice.entity.Client;
import com.example.clientservice.mapper.ClientMapper;
import com.example.clientservice.service.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Clients", description="API de gestion des clients")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;

    @Operation(summary = "Récupèrer la liste des clients")
    @GetMapping
    public List <ClientDTO> getAllClientDTOs(){
        return clientService.getAllClients().stream()
               .map(clientMapper::toClientDTO)
               .collect(Collectors.toList());
    }
  

    @Operation(summary = "Rechercher un client")
    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable Long id){
        return clientMapper.toClientDTO(clientService.getClientById(id));
    }


    @Operation(summary = "Créer un client")
    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO){
        Client client =clientMapper.toClient(clientDTO);
        return clientMapper.toClientDTO(clientService.saveClient(client));
    }

    @Operation(summary = "Supprimer un client")
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }


}
