package ma.fsm.TP3__Hopital.security;

import lombok.AllArgsConstructor;
import ma.fsm.TP3__Hopital.security.entities.AppUser;
import ma.fsm.TP3__Hopital.security.service.AccountService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private AccountService accountService ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = accountService.loadUserByUsername(username);
        if (user ==null){
            throw  new RuntimeException(String.format("user %s not Found", username)) ;
        }

        String[] tabeleau_Roles = user.getRoles().stream().map(u -> u.getRoleId()).toArray(String[]::new);
        UserDetails userDetails = User.withUsername(username)
                                      .password(user.getPassword())
                                      .roles(tabeleau_Roles)
                                      .build() ;
        return userDetails;
    }
    
}
