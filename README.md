# Microservices Spring Boot et Spring Cloud

## Description

Ce projet est une application de gestion des produits développée avec **Spring Boot** et **Spring Cloud**. Il constitue un service microservices qui permet de créer, lire, mettre à jour et supprimer des produits via une API RESTful. L'application utilise une base de données H2 en mémoire pour le stockage temporaire des données et intègre Swagger pour la documentation de l'API.

## Caractéristiques

- **Gestion des produits** : Effectuez des opérations CRUD sur les produits.
- **Documentation API** : Swagger est utilisé pour une documentation interactive et conviviale.
- **Base de données H2** : Utilise H2 en mode mémoire pour un développement rapide et efficace.
- **Microservices** : Conçu pour fonctionner dans un environnement de microservices, avec intégration à **Eureka** pour la découverte de services.

## Technologies Utilisées

- **Java** : Version 17
- **Spring Boot** : Version 3.3.5
- **Spring Cloud** : Version 2023.0.3
- **Spring Data JPA** : Pour l'accès aux données
- **H2 Database** : Base de données en mémoire
- **SpringDoc OpenAPI** : Pour la documentation de l'API
- **Eureka** : Pour la découverte des services

## Prérequis

Avant de commencer, assurez-vous d'avoir installé :

- Java 17
- Maven

## Installation

1. Clonez le dépôt :

   ```bash
   git clone https://github.com/votre-utilisateur/produit-service.git
   cd produit-service
   ```

2. Compilez le projet avec Maven :

   ```bash
   mvn clean install
   ```

3. Démarrez l'application :

   ```bash
   mvn spring-boot:run
   ```

## Accéder à l'API

- **Documentation Swagger** : Accédez à la documentation de l'API à l'adresse suivante :
  ```
  http://localhost:8080/swagger-ui/index.html
  ```

- **Console H2** : Pour accéder à la console H2 et visualiser les données, rendez-vous sur :
  ```
  http://localhost:8080/h2-console
  ```

  Utilisez les paramètres suivants pour vous connecter :
  - **JDBC URL** : `jdbc:h2:mem:produitdb`
  - **Username** : `sa`
  - **Password** : `password`

## Exemples d'utilisation

### Ajouter un produit

```http
POST /produits
Content-Type: application/json

{
    "nom": "Produit 1",
    "prix": 29.99,
    "categorieProduit": "ELECTRONIQUE"
}
```

### Obtenir la liste des produits

```http
GET /produits
```

### Obtenir un produit par ID

```http
GET /produits/{id}


## Contribution

Les contributions sont les bienvenues ! Pour contribuer, veuillez suivre ces étapes :

1. Forkez le projet.
2. Créez une nouvelle branche (`git checkout -b feature/nouvelle-fonctionnalite`).
3. Effectuez vos modifications et commit (`git commit -m 'Ajout d'une nouvelle fonctionnalité'`).
4. Poussez la branche (`git push origin feature/nouvelle-fonctionnalite`).
5. Ouvrez une Pull Request.


