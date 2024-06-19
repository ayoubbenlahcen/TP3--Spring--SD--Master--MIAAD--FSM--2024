package ma.fsm.TP3__Hopital.security.service;

import lombok.AllArgsConstructor;
import ma.fsm.TP3__Hopital.security.entities.AppRole;
import ma.fsm.TP3__Hopital.security.entities.AppUser;
import ma.fsm.TP3__Hopital.security.repo.AppRoleRepository;
import ma.fsm.TP3__Hopital.security.repo.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service  // pour  specofier que celui la c'est un service
@AllArgsConstructor // c'est  pour faire injection des dependances
@Transactional   // avec  cette  anotation toute les methodes sont transacionel
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository ;
    private AppRoleRepository appRoleRepository  ;
    private PasswordEncoder passwordEncoder ;
    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmPasword) {

        AppUser appUser = appUserRepository.findByUsername(username);
        if(appUser!= null){
            throw  new RuntimeException("this user already exist") ;
        }
        if (!password.equals(confirmPasword)){
            throw  new RuntimeException("Password note match") ;
        }
        appUser = AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
        AppUser savedUser = appUserRepository.save(appUser);
        return savedUser;
    }

    @Override
    public AppRole addNewRole(String role) {
        AppRole appRole = appRoleRepository.findById(role).orElse(null) ;
        if (appRole==null ){
            throw  new RuntimeException("This role already exist") ;
        }
        appRole = AppRole.builder()
                .roleId(role)
                .build();
        AppRole saveRole = appRoleRepository.save(appRole);

        return saveRole;
    }

    @Override
    public AppUser addRoleToUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        appUser.getRoles().add(appRole) ;
        /*
            c'est pas l'appel de  faire ecrire  ;
            appUserRepository.save(appUser) ;
            car cette methode est transactionnel (comme tous les autere methodes grace au a la notation @Transactional
            alors puis que on a ajouter le role a  la liste  ,
            alors quand la fonction ce termine le Commit va se fait automatiquent
            tant que on  a pas une exception qui va etre lancer / generer
            )
         */

        return null;
    }

    @Override
    public Void removeRoleFromUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username) ;
        AppRole appRole = appRoleRepository.findById(role).get() ;
        appUser.getRoles().remove(appRole) ;
        return null;
    }

    @Override
    public AppUser loadUserByUsername(String userName) {
        return appUserRepository.findByUsername(userName) ;
    }
}
