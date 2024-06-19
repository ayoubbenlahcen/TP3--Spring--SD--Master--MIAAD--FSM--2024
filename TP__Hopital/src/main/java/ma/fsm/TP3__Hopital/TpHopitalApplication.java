package ma.fsm.TP3__Hopital;

import ma.fsm.TP3__Hopital.entities.Patient;
//import ma.fsm.TP3__Hopital.repository.PatientRepository;
import ma.fsm.TP3__Hopital.repositories.PatientRepository;
import ma.fsm.TP3__Hopital.security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.Date;

@SpringBootApplication
public class TpHopitalApplication   {

    public static void main(String[] args) {
        SpringApplication.run(TpHopitalApplication.class, args);

    }


    //@Override

    //public void run(String... args) throws Exception {
        // pour creer un patient j'ai Trois facon de le faire
        // la premiere facon est :



/*
        // la deusieme solution est la suivant
        Patient patient = new Patient() ;

        patient.setId(null);
        patient.setNom("Ayoub");
        patient.setDateNaissance(new Date());
        patient.setScore(3);
        patient.setMalade(true);
        //patientRepository.save(patient) ;

        // la troisieme faicon de le faire est la suivant en utilisant le Builder :
                Patient patient3 = Patient.builder()
                .nom("ayoub")
                .dateNaissance(new Date())
                .score(2).malade(true)
                .build();
*/
        //patient2Repository.save(patient1);
        //patient2Repository.save(patient2);
        //patient2Repository.save(patient3);


        /*
           maintenant on  va passer derectement a Spring MVC (la patie Web)
           pour cela on va essayer de creer  dans le package :
           une classe PatientController et pour qu'ils soit un controlleur on a besoin de faire avant cette classe
           une annotation  qui s'appel:
           @controller qui indique que la classe suivant va etre un controlleur

         */

    //}

    //@Bean
    CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "Hassan", new Date(), false, 12));
            patientRepository.save(new Patient(null, "Mohammed", new Date(), true, 321));
            patientRepository.save(new Patient(null, "Yasmine", new Date(), true, 65));
            patientRepository.save(new Patient(null, "Hanae", new Date(), false, 32));

            patientRepository.findAll().forEach(patient -> {
                System.out.println(patient.getNom());
            });
        };
    }
    // on peut faire une ignoration de ce  execution tel que il ne va pas etre execute dans le lancement de Spring chaque fois
    // sans commante le code iol suffit de  commanter @Bean

    //@Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
        PasswordEncoder passwordEncoder = passwordencoder() ;
        return args -> {
          //jdbcUserDetailsManager.createUser(User.withUsername("user1").password(passwordencoder("1234")).roles("USER").build());
          //jdbcUserDetailsManager.createUser(User.withUsername("user2").password(passwordencoder("1234")).roles("USER").build());
          //jdbcUserDetailsManager.createUser(User.withUsername("admin").password(passwordencoder("1234")).roles("USER" , "ADMIN").build());
          /*
          le probleme que j'ai c'est que je si j'ai essayer de restart mon application a nouveau un exception se lonce ce qui n'est  pas bien d'une facon ou d'une autre
          alors la solustion c'est  quoi :

          c'est  de faire chercher une fois que je veux creer un utilisateur je dois  faire un teste   si existe deja c'est pas l'appelde l'ajouter
          sion je l'ajoute a la base de donne
           */

            /*  on a fait ca dans le cas ou on suppprimer manuellement les users de puis la base de donne alors une expption se genere
                a cause de l'instruction
                                        UserDetails user1 = jdbcUserDetailsManager.loadUserByUsername("user1");
                                        dans le cas ou l'utlisateur n'existe pas dans la base
             */
            try {
                // tous va passer bien  dans  ce block si lutilisateur existe dans  la base
                UserDetails user1 = jdbcUserDetailsManager.loadUserByUsername("user1");
            }catch (Exception e){
                // le case ou on a une exception c'est a  dire que  :  user n'existe pas dans la base
                jdbcUserDetailsManager.createUser(User.withUsername("user1").password(passwordEncoder.encode("1234")).roles("USER").build());
            }

            try {
                UserDetails user2 = jdbcUserDetailsManager.loadUserByUsername("user1");
            }catch (Exception e){
                jdbcUserDetailsManager.createUser(User.withUsername("user2").password(passwordEncoder.encode("1234")).roles("USER" ).build());
            }
            try {
                UserDetails admin = jdbcUserDetailsManager.loadUserByUsername("admin");
            }catch (Exception e){
                jdbcUserDetailsManager.createUser(User.withUsername("admin").password("1234").roles("USER" , "ADMIN").build());
            }
        };
        }


    //@Bean
    CommandLineRunner commandLineRunnerUserDetails(AccountService accountService){
        PasswordEncoder passwordEncoder = passwordencoder() ;
        return args -> {


            accountService.addNewUser("user1" , "1234","user1@gmail.com" , "1234" ) ;
            accountService.addNewUser("user2" , "1234","user2@gmail.com" , "1234" ) ;
            accountService.addNewUser("user3" , "1234","user3@gmail.com" , "1234" ) ;

            accountService.addRoleToUser("user1" , "ADMIN") ;
            accountService.addRoleToUser("user2" , "USER") ;
            accountService.addRoleToUser("user2" , "USER") ;

        };
    }
     /*
         si on a  pas fais @ Bean  alors quand je veux faire l'authentification,
         Spring va  recouperer le Password saisie il n'arrive pas de connaitre dans qu'il forme est codé
         ce qui va generer une exception
      */

    @Bean
    public static PasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }

}


