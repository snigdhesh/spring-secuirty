package com.example.springsecuritydemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.springsecuritydemo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

  private PasswordEncoder passwordEncoder;

  @Autowired
  public ApplicationSecurityConfig(PasswordEncoder passwordEncoder){
    this.passwordEncoder=passwordEncoder;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf().disable()
      .authorizeRequests()
      .antMatchers("/","index","/css/*","/js/*","styles").permitAll()
      .antMatchers("/api/**").hasRole(STUDENT.name())
      .anyRequest()
      .authenticated()
      .and()
      .httpBasic();
  }

  @Override
  @Bean
  //This is how you access user details from db.
  protected UserDetailsService userDetailsService() {
    UserDetails annaSmith = User.builder()
      .username("annasmith")
      .password(passwordEncoder.encode("password"))
      .roles(STUDENT.name())//spring security understands this as ROLE_STUDENT
      .build();

    UserDetails linda=User.builder()
      .username("linda")
      .password(passwordEncoder.encode("password123"))
      .roles(ADMIN.name())
      .build();

    UserDetails tom=User.builder()
      .username("tom")
      .password(passwordEncoder.encode("password123"))
      .roles(ADMINTRAINEE.name())
      .build();
    return new InMemoryUserDetailsManager(annaSmith,linda,tom );
  }
}
