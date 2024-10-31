package com.example.produit_service.dto;

import com.example.produit_service.enums.CategorieProduit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDTO {
   private Long id;
   private String nom;
   private double prix;
   private CategorieProduit categorieProduit;
}
