package ma.fsm.TP3__Hopital.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        private  UserDetailServiceImpl userDetailService ;

    /*
        pour faire basculer vers UserDtailsService on est besoin :
        de creer une classe quand en va lui donne comme nom "UserDetailServiceImpl"  :

            qui  va implimenter l'interface "UserDetailService"  qui est offrit par Spring Security
            en effet cette interface definit une seul  methode qu'il faut le redifinir dans "UserDetailServiceImpl" qui s'appelle "loadUserByUsername"

            tous simplement Spring security en utilisant la  methode de  UserDtailsService :
                chaque fois que l'utilisateur va saisir son UserName et Son mode passe il va faire l'appele a la methode  "loadUserByUsername"

            Alors la seule chose quand on va remarquer ici c'est que  cette methode dans les autre facon de la gestion des user est deja  predifinie

                 quelque Soit :  dans le cas de InMemoryAuthentication      ou            :     dans le JdbcUserDetailsManager
            par contre dans : UserDetailsService c'est a nous de faire l'implimentaion ou de definir cette methode


            comme suite :
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
                    return null;
                }
            }

     */
    //@Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){ /* on a fait l'injection de dataSource
                                                                                     c'est pour  eindique a Spring  que si tu veux chercher un USER
                                                                                    essayser de faire cette recherche dans le data Source (dans la base de donne)
                                                                                 */
        /* Avec JdbcUserDetailsManager je suis besoin de faire ajouter/Creer deux Table dans la base de donne

            une table pour creer les utilisateur et une autree pour les role (les autorities)
            pour faire ça il faut que ces table vont avoir une  structure qui est deja connue par Spring security

         */

        return new JdbcUserDetailsManager(dataSource) ;
    }
    //@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("user").password("{noop}1234").roles("USER").build() ,
                User.withUsername("user2").password("{noop}1234").roles("USER").build() ,
                User.withUsername("admin").password("{noop}1234").roles("USER", "ADMIN").build()
        ) ;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        /*
        par fois il possible de trouver que par fois quant en tante d'acceder a l'application c'est a dire qu'on a
        l'impression quand on fait l'authentification deux fois :
        alors il faut  compredre qu'est ce qu'est ce passe
            Spring nous redérige vers la ressource demander depuis le deppart c'est a dire si

           j'ai demandé /index depuis le depart  alors si l'authentification paas bien il va me rederiger vers indexe apres l'autentification

           meme chose quand en demande "/login"  la redirection vers la page d'authentification main une fois j'authentifie
           il va me redirige vers la ressouce demande depuis le depart qui est "login"

       Solution de ce petit probleme c'est que  au lieu de faire :
                 httpSecurity.formLogin().loginPage("/login").permitAll() ;

        en le remplace par :
                 httpSecurity.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll() ;
                 =========> rediriger moin apres l'authentification vers la ressoutce : "/"
                 definir un view qui  qui a comme getMapping("/")
                 pour eviter les problemes  que la resource demmande ne se trouve pas
         */
          httpSecurity.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll() ;
          httpSecurity.rememberMe() ;
          httpSecurity.authorizeHttpRequests().requestMatchers("/webjars/**" ,"h2-console/**").permitAll();
          httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
          httpSecurity.userDetailsService(userDetailService) ;

        return httpSecurity.build();
    }
}
