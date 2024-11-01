package com.example.clientservice.mapper;

import org.mapstruct.Mapper;

import com.example.clientservice.dto.ClientDTO;
import com.example.clientservice.entity.Client;

@Mapper(componentModel="spring")
public interface ClientMapper {
     ClientDTO toClientDTO(Client client);
     Client toClient(ClientDTO clientDTO);
}
