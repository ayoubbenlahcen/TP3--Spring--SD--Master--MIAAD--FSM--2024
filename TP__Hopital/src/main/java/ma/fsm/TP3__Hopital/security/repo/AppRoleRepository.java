package ma.fsm.TP3__Hopital.security.repo;

import ma.fsm.TP3__Hopital.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole , String> {
}
