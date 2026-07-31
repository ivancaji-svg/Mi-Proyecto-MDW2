package com.utp.ventasMVC.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService users()
    {
        UserDetails admin= User.builder().username("admin")
                                         .password("{noop}1234")
                                         .roles("ADMIN")
                                         .build();
        UserDetails user= User.builder().username("juan")
                .password("{noop}1234")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**","/uploads/**").permitAll()
                        .requestMatchers("/").authenticated()
                        .requestMatchers("/categorias/**").hasRole("ADMIN")
                        .requestMatchers("/productos/**").hasAnyRole("ADMIN","USER")
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .logout(logout -> logout.logoutSuccessUrl("/login").permitAll())
                .exceptionHandling(ex->ex.accessDeniedPage("/acceso-denegado")) ;
        return http.build();
      }

}



