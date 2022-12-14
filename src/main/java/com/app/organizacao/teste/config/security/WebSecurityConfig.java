/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.organizacao.teste.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author João Felipe
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter/*Classe que onde conseguimos realizar configurações costumizadas da segurança*/ {

    @Override
    protected void configure(HttpSecurity http) throws Exception { // Realiza a configuração do HttpSecurity
        http
                .httpBasic()//Definimos que iremos utilizar o tipo de http
                .and()//Serve para unir as configurações 
                .authorizeRequests()//
                .anyRequest().authenticated()
                .and()
                .csrf().disable(); //desabilta o csrf
    }
    
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder  ();
    }
}
