# Projet CRUD Web avec JEE

Ce projet est une application web de type CRUD (Create, Read, Update, Delete) développée en utilisant Java Enterprise Edition (JEE) et Maven pour la gestion des dépendances.

## Structure du projet

- `.settings/` : Contient les fichiers de configuration de l'IDE Eclipse.
- `build/classes/ma/fstt/entities/` : Répertoire généré contenant les classes compilées du projet.
- `src/main/` : Contient le code source principal du projet, y compris les servlets, les fichiers JSP, les entités JPA, etc.
- `target/` : Répertoire utilisé par Maven pour stocker les fichiers compilés et les packages générés.
- `.classpath` : Fichier de configuration spécifique à Eclipse définissant le chemin de classe du projet.
- `.project` : Fichier de configuration du projet Eclipse.
- `pom.xml` : Fichier de configuration Maven contenant les dépendances et les configurations de build.

## Fonctionnalités

- Créer, lire, mettre à jour et supprimer des entités à partir d'une base de données.
- Utilisation de servlets et de JSP pour gérer les requêtes HTTP.
- Intégration de JPA (Java Persistence API) pour la gestion de la persistance des données.
- Interface utilisateur simple via des pages JSP.

## Prérequis

- Java JDK 8 ou version ultérieure
- Apache Maven 3.6.0 ou version ultérieure
- Serveur d'application compatible JEE (comme Apache Tomcat ou JBoss)
- Base de données (MySQL, PostgreSQL, etc.)

## Installation

1. Clonez le dépôt :

   ```bash
   git clone <url-du-repo>
   
2. Accédez au répertoire du projet :

   ```
   cd nom-du-repertoire-du-projet```

3. Configurez la connexion à la base de données dans le fichier persistence.xml, situé dans src/main/resources/META-INF/, pour y inclure vos informations de base de données (URL, utilisateur, mot de passe).

