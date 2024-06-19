package ma.fsm.TP3__Hopital.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class AppUser {
    /*
        Ici il est possible de faire ajouter d'autre  attribue qui va caracteriser notre User
     */
    @Id
    private  String userId ;
    @Column(unique = true)
    private  String username ;
    private  String password ;

    @Column(unique = true)
    private  String email ;

    @ManyToMany(fetch = FetchType.EAGER) //si on demander  a Spring de charger les information d'un user il
                                        // il ne va pas charger les roles seulemen dans le cas ou nous on
                                        // veut les charger on en est besoin (le mode Lasy = le mode parisseur)
                                        // (le mode EAGER =  c'est charger les role aussi quand je demande de les information d'un user  )
                                        // on a choisie EAGER  car  chaque fois quand je suis besoin d'un utlilisateur je  suis besois de  ces roles
    private List<AppRole> roles  ;
}
