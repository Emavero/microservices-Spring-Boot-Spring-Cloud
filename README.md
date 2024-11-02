# Microservices Spring Boot et Spring Cloud

## Description

Ce projet est une application de gestion des clients et des produits développée avec **Spring Boot** et **Spring Cloud**. Il repose sur une architecture de microservices pour gérer les opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) sur les produits et les clients. Le projet utilise Eureka pour la découverte de services et une passerelle API pour acheminer les requêtes aux services appropriés. Les services utilisent une base de données H2 en mémoire pour le stockage temporaire des données et intègrent Swagger pour la documentation de l'API.

## Caractéristiques

- **Gestion des produits et des clients** : Effectuez des opérations CRUD sur les entités produits et clients via des services distincts.
- **Documentation API** : Swagger est utilisé pour une documentation interactive et conviviale.
- **Base de données H2** : Utilise H2 en mode mémoire pour un développement rapide et efficace.
- **Microservices** : Conçu pour fonctionner dans un environnement de microservices, avec intégration à **Eureka** pour la découverte de services et **API Gateway** pour acheminer les requêtes.
- **Communication inter-services** : Utilise OpenFeign pour permettre la communication entre les services `clientservice` et `produitservice`.

## Architecture

L'architecture du projet est composée de plusieurs microservices :

1. **produit-service** : Gère les produits et expose des endpoints pour créer, lire, mettre à jour et supprimer des produits.
2. **clientservice** : Gère les clients et expose des endpoints pour créer, lire, mettre à jour et supprimer des clients. Il communique avec `produit-service` pour récupérer des informations sur les produits.
3. **Eureka Server** : Assure la découverte des services, permettant aux services de se localiser mutuellement.
4. **API Gateway** : Fournit une passerelle unifiée pour accéder aux différents microservices et gérer le routage des requêtes.

## Technologies Utilisées

- **Java** : Version 17
- **Spring Boot** : Version 3.3.5
- **Spring Cloud** : Version 2023.0.3
- **Spring Data JPA** : Pour l'accès aux données
- **H2 Database** : Base de données en mémoire
- **SpringDoc OpenAPI** : Pour la documentation de l'API
- **Eureka** : Pour la découverte des services
- **API Gateway** : Pour le routage des requêtes vers les microservices
- **OpenFeign** : Pour la communication inter-services

## Prérequis

Avant de commencer, assurez-vous d'avoir installé :

- Java 17
- Maven

## Installation

1. Clonez le dépôt :

   ```bash
   git clone https://github.com/votre-utilisateur/microservices-architecture.git
   cd microservices-architecture
   ```

2. Compilez le projet avec Maven :

   ```bash
   mvn clean install
   ```

3. Démarrez les microservices dans l'ordre suivant pour garantir une bonne configuration :

   ```bash
   # Démarrez le serveur Eureka
   cd eureka-server
   mvn spring-boot:run

   # Démarrez le service produit
   cd ../produit-service
   mvn spring-boot:run

   # Démarrez le service client
   cd ../clientservice
   mvn spring-boot:run

   # Démarrez la passerelle API
   cd ../api-gateway
   mvn spring-boot:run
   ```

## Accéder à l'API

- **Documentation Swagger de produit-service** : 
  ```
  http://localhost:8081/swagger-ui/index.html
  ```

- **Documentation Swagger de clientservice** : 
  ```
  http://localhost:8083/swagger-ui/index.html
  ```

- **API Gateway** : Toutes les requêtes peuvent être envoyées via la passerelle pour accéder aux services, par exemple :
  ```
  http://localhost:8082/clientservice/clients
  http://localhost:8082/produit-service/produits
  ```

- **Console H2** : Pour accéder à la console H2 et visualiser les données pour chaque service, utilisez les URLs et configurations propres à chaque service (`produit-service` et `clientservice`).

## Exemples d'utilisation

### Ajouter un produit

```http
POST /produit-service/produits
Content-Type: application/json

{
    "nom": "Produit 1",
    "prix": 29.99,
    "categorieProduit": "ELECTRONIQUE"
}
```

### Ajouter un client

```http
POST /clientservice/clients
Content-Type: application/json

{
    "nom": "Ensias",
    "prenom": "Genie Logiciel"
}
```

### Obtenir un produit par ID via clientservice

Utilisez `clientservice` pour récupérer des informations sur un produit spécifique.

```http
GET /clientservice/clients/{clientId}/produits/{produitId}
```

## Contribution

Les contributions sont les bienvenues ! Pour contribuer, veuillez suivre ces étapes :

1. Forkez le projet.
2. Créez une nouvelle branche (`git checkout -b feature/nouvelle-fonctionnalite`).
3. Effectuez vos modifications et committez (`git commit -m 'Ajout d'une nouvelle fonctionnalité'`).
4. Poussez la branche (`git push origin feature/nouvelle-fonctionnalite`).
5. Ouvrez une Pull Request.

## Améliorations Futures

- Ajouter un service de facturation pour traiter les transactions clients-produits.
- Intégrer des tests d'intégration automatisés pour les communications entre microservices.
- Mettre en place un service de notification pour alerter les clients en temps réel.
