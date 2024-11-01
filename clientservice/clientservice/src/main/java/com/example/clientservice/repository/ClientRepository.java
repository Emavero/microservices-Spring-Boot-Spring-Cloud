package com.example.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clientservice.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
