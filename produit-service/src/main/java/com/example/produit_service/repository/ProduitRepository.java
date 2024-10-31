package com.example.produit_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.produit_service.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long>{
    
}
