package com.example.produit_service.mapper;

import org.mapstruct.Mapper;

import com.example.produit_service.dto.ProduitDTO;
import com.example.produit_service.entity.Produit;


@Mapper(componentModel = "spring")
public interface ProduitMapper {
    ProduitDTO toDTO(Produit produit);
    Produit toEntity(ProduitDTO produitDTO);
}
