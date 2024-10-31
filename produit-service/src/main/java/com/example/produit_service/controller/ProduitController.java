package com.example.produit_service.controller;


import org.springframework.web.bind.annotation.RestController;

import com.example.produit_service.dto.ProduitDTO;
import com.example.produit_service.entity.Produit;
import com.example.produit_service.mapper.ProduitMapper;
import com.example.produit_service.service.ProduitService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;





@RestController
@RequestMapping("/api/produits")
@Tag(name = "Produits", description = "API de gestion des produits")
public class ProduitController {
   
 @Autowired
 private ProduitService produitService;
 
 @Autowired
 private ProduitMapper produitMapper;

 @Operation(summary = "Récupère tous les produits")
 @GetMapping
 public List <ProduitDTO> getAllProduits(){
    return produitService.getAllProduits().stream()
           .map(produitMapper::toDTO)
           .collect(Collectors.toList());
         }
 
 @Operation(summary = "Récupère un produit par son identifiant")
 @GetMapping("/{id}")
 public ProduitDTO getProduitById(@PathVariable Long id){
    return produitMapper.toDTO(produitService.getProduitById(id));
 }

 @Operation(summary = "Crée un nouveau produit")
 @PostMapping
 public ProduitDTO createProduit(@RequestBody ProduitDTO produitDTO){
    Produit produit =produitMapper.toEntity(produitDTO);
    return produitMapper.toDTO(produitService.saveProduit(produit));
 }

 
 @Operation(summary = "Supprime un produit par son identifiant")
 @GetMapping("/{id}")
 public void deleteProduit(@PathVariable Long id){
    produitService.deleteProduit(id);
 }


 }
 
   

    

