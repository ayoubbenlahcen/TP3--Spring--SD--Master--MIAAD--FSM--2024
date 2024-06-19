# TP3--Spring--SD--Master--MIAAD--FSM--2024

Dans ce rapport, nous allons détailler le processus de création d'une application Web JEE pour la gestion des patients en utilisant Spring MVC, Thymeleaf, Spring Data JPA et Spring Security, en suivant les tutoriels vidéo fournis. L'application permettra d'afficher, chercher, paginer et supprimer des patients, tout en ajoutant des fonctionnalités supplémentaires pour améliorer l'expérience utilisateur. Nous aborderons également la création d'une page modèle, la validation des formulaires et l'intégration de la sécurité avec Spring Security, notamment l'authentification en mémoire et via JDBC.

##  Partie 1 :
Créer une application Web JEE basée sur Spring MVC, Thylemeaf et Spring Data JPA qui permet de gérer les patients. 
L'application doit permettre les fonctionnalités suivantes :

   - Afficher les patients
   - Faire la pagination
   - Faire la pagination
   - Chercher les patients
   - Supprimer un patient
   - Faire des améliorations supplémentaires
     
## 1.1 Configuration du projet
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/06f4f174-8321-4a83-89ff-831e1d0dffe6)

## 1.2 Gestion des patients
### 1.2.1 Création de l'entité Patient
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/64ef38ff-378e-4a51-a56e-c1938e8ff1ad)

### 1.2.2 Création du repository PatientRepository
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/1e3018b3-6370-4281-8aa9-d4f0900c10c5)

### 1.2.3 Création des contrôleurs
#### La creation du Patient controller : 
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/41f4a6c4-9098-4cab-ba5f-032c9018a222)
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/90fc7c9b-bbec-4c1e-974e-610e009a9371)
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/19db2825-b852-4a12-94e0-bdfee9f6431f)


### 1.2.4 Création des vues Thymeleaf

## Partie 2  : 
### 2.1 Créer une page template
/// imgages
### 2.2 Faire la validation des formulaires
/// imgages

## Partie  3 : Sécurité avec Spring security  :
### 3.1 en utilisant InMemomy Authentication:
///: images
### 3.2 en utilisant JDBC Authentication :
/// images
### 3.3 en utilisant UserDetails Service :
