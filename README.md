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

### 1.1.1 La configuration du fichier application.properties : 
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/05deab0e-0cce-4010-bd66-9ce99d8c0664)

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

## Partie 2  : 
### 2.1 Créer des pages page templates : 
   - EditPatient.html
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/d871620e-2dcb-4fd9-9623-c3fe985452d3)
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/ac736609-4402-430f-9a01-d5290d99c487)

   - formePatients.html
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/611ef21b-c40a-4d72-af28-5fbfc370c572)
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/7b13ba9a-3da2-45a0-9632-2e24a9c2c571)

   - login.html
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/796bf4f5-2a0f-4fa7-8fb7-280b4586e62d)

   - notAuthorized.html
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/1d011e17-e169-45b2-aec4-4d660358309f)
   - patients.html
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/f890581f-df0b-44d9-a225-9fa5303200a3)

   - profile.html
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/209c4c5a-9b57-4bff-af19-50ff4430e178)

   - template1.html
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/a82ad37e-bd78-47e0-9c30-9f0e7092b6f6)
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/8c00507f-9561-4e33-9894-8c1ab21f2f65)

#### remarque : ==========================================================================================================
   - dans tous ces templates on  a utlise bootstrap pour faire le css alors pour avoir l'utiliser il faut :
     1- ajouter la dependance  suivant dans le fichier pom.xml :
     
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/a72a82dd-e904-4a28-8b23-c899cd06f52f)

     puis faire les liens suivantes dans les pages html pour l'utiliser :
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/f0ac5e0a-9b83-474a-97c2-45e195a9d00a)

   - dans tous ces templates on  a utliser Thymeleaf qui est un moteur de template Java utilisé pour générer des vues dans les applications web basées sur Java, Voici comment on peut l'utilisé :
     1) Ajouter la dependance suivant  :
       ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/37c1815c-ce55-4abb-ab0f-f9a896de28f1)

     2)  puis faire ajouter dans la balise html cette : ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/5a3b7e0b-94da-4736-b6b6-bc76ed9c6d04)

   - On a utlisé la composition et l'héritage de templates et pour le faire il suffit de faire ajouter l'attribue suivant dans le tag html  :
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/eef5769b-d60a-4c23-8912-420221515bc6)
     dans la templte qui va etre herite par d'autre template (dans notre cas on a essayer de l'uliliser dans la page template1.html) ,

     ensuite en ajoute dans n'importe qui page qui va heriter  la page  template1.html par exemple le code suivant  :
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/efea0e5f-cc45-4a46-83fa-0e7d74c16ad6)



### 2.2 Faire la validation des formulaires: 
Alors dans ce cas on va essayer de faire ca seulment pour la formulaire d'ajoute d'un patient : 
##### 1. faire la creation de la page html pour notre fomulaire correspand a l'ajoute d'un patient :
         - Comme on fait precidament (voir la template de formPatient.html)  :
##### 2. En suite en est besoin d'un controlleur  pour faire le redirection vers cette page tel que il faut instancier un objet de type Patient puis l'ajouter dans le model  Voici un exemple de ce controllleur :
      Voici la signification de quelque notations utliser dans cette partie :
      - @GetMapping(path = "/editPatient") : c'est pour spcifier le mot que je dois ecrire dans l'URL pour lancer ce controlleur
      - @PreAuthorize("hasRole('ROLE_ADMIN')") : ca lie a la partie securite on va parler sur ca plutart mais on peut dire que il ets utliser pour dier que ce lui ne peut etre executer seulment si l'utilisateur est un Admin
   
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/23944d02-b7b0-4493-90a9-a7fc396739c2)

##### 3. En  suite en est besoin de faire creer un autre controlleur pour faire la validation ou bien  le sauvegarde d'un patient  dans la base de donnée Voici un exemple  pour faire ça :
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/9b00dd15-0a14-4e78-a36e-1e6aaea8ae97)


## Partie  3 : Sécurité avec Spring security  :
Alors Spring Security est un sous-projet du framework Spring qui se concentre sur la fourniture de l'authentification et de l'autorisation pour les applications Java. Il est conçu pour sécuriser les applications web et les services RESTful, en intégrant facilement des mécanismes de sécurité robustes.
concentrons-nous sur les trois méthodes spécifiques d'authentification avec Spring Security :

### 3.1. premierement il faaut ajouter la dependance suivant dans notre fichier pom.xml : 
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/777017bc-301c-4428-964a-0ca13feeab61)
### 3.2. faire creer un package pour la securité quand on va appeller par exemple security : 
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/0f32f147-5d40-40d3-9737-446e11e1f065)
### 3.3.  a besoin  de cerrier un fichier de configuration qui quand on va appeler SecurtyConfig afin de choisir qu'il methode quand on veut utiliser poue securiser notre application voici ces methode là :

### 3.3.1 en utilisant InMemomy Authentication:
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/4ed5e404-16eb-424f-bda0-e0e92b4beb33)
Exemple d'utlisation dans le main : 

### 3.3.2 en utilisant JDBC Authentication :
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/d82a41e7-f185-4b88-9130-fb07303ccf21)
En est besoin dans cette partie de faire creer un fichier schema.sql  qui va contenir la creation des deux tables users et authorities en utlisant le langage MariaDialect voici quoi ce fichier va contenir :
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/143b2ae4-3b94-4436-acfa-45a52c1def53)
Exemple d'utlisation dans le main : 
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/6fd574a9-d05a-4e89-bde8-d5478fdea877)

#### Remarque  : 
   - Il faut faire une petit modefication dans le fichier application.proprties ci en veut que la secrite avec JDBC  Authentication reussite , c'est que il faut mettre spring.jpa.hibernate.ddl-auto=none

### 3.3.3 en utilisant UserDetails Service :
![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/d44f1ad6-1031-4ffe-bb35-66aebbf8dfcd)

dans le cas d'utlisation de la maniere  UserDetails Service , au plus de cette configuration on est besoin de creer les entites users et roles avec les defferent repository correspande a chaque entité et aussi le service Voici comment on va faire ça :
   - Une UserDetailServiceImpl  pour faire le load des information d'un user   : 
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/d76da3e0-866c-4337-96e4-bf330e55bd32)
     
   - Une entite AppUser  :
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/0143285e-b1d0-4793-af69-44eac9a5bf35)
     
   - Une entite AppRole  :
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/0b93c1f9-eb77-4f2b-83b6-9b824f35b000)

   -   AppRoleRepository : 
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/3b0c0bf7-a378-4b60-8fef-e701653b6bd4)

   -   AppUserRepository : 
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/1ae81c77-0739-4b49-bb28-40c814214d63)

   -   Une interface AccountService : 
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/d66bbb7e-9251-4a26-8616-2e0d71c2400e)

   -   AccountServiceImpl qui va implementer AccountService : 
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/d59edc9d-ba00-429b-a0ca-2f685739bac0)
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/07927933-ea48-4dbd-a8d0-a81e97fd6fbc)
     ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/0b6de095-48c6-49c4-bf6b-f05efee710d8)

     Exemple d'utlisation dans le main : 
   ![image](https://github.com/ayoubbenlahcen/TP3--Spring--SD--Master--MIAAD--FSM--2024/assets/152870306/5e66fa65-8632-4d98-81b9-af6e493ea494)




![image](https://github.com/ayoubbenlahcen/ayoubbenlahcen-ayoubbenlahcen-SD_MIAAD_FSM_TP2_2024/assets/152870306/77782a46-44c4-43a7-a07e-cf4d8dd4c94d)
