package eni.demo.demo.module4.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    //@Bean
    public UserDetailsService userDetailsService() {


        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails userDetails1 = User.withDefaultPasswordEncoder()
                .username("user1")
                .password("password")
                .roles("USER")
                .build();

        UserDetails userDetails2 = User.withDefaultPasswordEncoder()
                .username("user2")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(userDetails, userDetails1, userDetails2);
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT pseudo, password, 1 FROM utilisateur WHERE pseudo=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT pseudo, role FROM roles WHERE pseudo=?");

        return jdbcUserDetailsManager;
    };


    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/chocolatine").hasAuthority("ROLE_EMPLOYE")
                        .requestMatchers("/show-aliments").hasAuthority("ROLE_FORMATEUR")
                        .requestMatchers("/show-aliment/**").hasAuthority("ROLE_FORMATEUR")
                        .requestMatchers("/demo-debug").hasAnyAuthority("ROLE_FORMATEUR","ROLE_EMPLOYE","ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET,"/show-aliment-form").hasAnyAuthority("ROLE_FORMATEUR","ROLE_EMPLOYE")
                        .requestMatchers(HttpMethod.POST,"/show-aliment-form").hasAnyAuthority("ROLE_FORMATEUR","ROLE_EMPLOYE")
                        .requestMatchers("/make-basket").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/show-basket-2").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/clear-basket").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").authenticated()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/vendor/**").permitAll()

                        .anyRequest().denyAll());


                        http.formLogin(Customizer.withDefaults());





        return http.build();
    }




}


