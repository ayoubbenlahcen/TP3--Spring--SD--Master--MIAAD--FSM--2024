package ma.fsm.TP3__Hopital.security.repo;

import ma.fsm.TP3__Hopital.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser , String> {
    AppUser findByUsername(String username) ;
}
