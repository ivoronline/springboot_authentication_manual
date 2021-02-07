package com.ivoronline.springboot_authentication_manual.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  //====================================================================
  // CONFIGURE
  //====================================================================
  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {

    //SPECIFY ACCESS TO ENDPOINTS
    httpSecurity.authorizeRequests().antMatchers("/Authenticate").permitAll(); //Anonymous     Access
    httpSecurity.authorizeRequests().anyRequest().authenticated();             //Authenticated Access

  }

}
