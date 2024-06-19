package ma.fsm.TP3__Hopital.security.service;

import ma.fsm.TP3__Hopital.security.entities.AppRole;
import ma.fsm.TP3__Hopital.security.entities.AppUser;

public interface AccountService {
    /*
    Ici il est possible de faire ajouter d'autre  fonctionalite que je peut les utiliserr pour gerer le compte de mes utilisateur
    tels que :
    une fonction pour verifcation de Email  , changer le Mode passe , il y a plien de chose quand on peut ajouter
 */
    AppUser addNewUser(String username ,String password ,String email ,String ConfirmePasword ) ;
    AppRole addNewRole(String role ) ;
    AppUser addRoleToUser(String username  , String role ) ;

    Void removeRoleFromUser(String username , String role) ;

    AppUser loadUserByUsername(String userName) ;


}
