package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final CustomUsernamePasswordAuthenticationProvider authenticationProvider;

    public WebSecurityConfig(PasswordEncoder passwordEncoder,
                             CustomUsernamePasswordAuthenticationProvider authenticationProvider) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/assets/**", "/register", "/login", "/izvestuvanje", "/izvestuvanje/details/**", "/profesor", "/profesor/details/**", "/predmet", "/predmet/details/**", "/contact", "/contact/**").permitAll()
                .antMatchers("/admin/**", "/dnevnik/delete/**", "/dnevnik/edit-form/**", "/dnevnik/add-form/**", "/ucenik/delete/**", "/ucenik/edit-form/**", "/ucenik/add-form/**", "/izvestuvanje/delete/**", "/izvestuvanje/edit-form/**", "/izvestuvanje/add-form/**").hasRole("PROFESOR")
                .antMatchers("/admin/**").hasRole("UCENIK")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .failureUrl("/login?error=BadCredentials")
                .defaultSuccessUrl("/ucenik", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.inMemoryAuthentication()
//                .withUser("kostadin.mishev")
//                .password(passwordEncoder.encode("km"))
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("admin")
//                .password(passwordEncoder.encode("admin"))
//                .authorities("ROLE_ADMIN");
        auth.authenticationProvider(authenticationProvider);
    }



}

