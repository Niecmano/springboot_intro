/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store;

import com.erstesrping.store.repository.KorisnikRepository;
import com.erstesrping.store.model.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 *
 * @author darko
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Override
    public UserDetails loadUserByUsername(String username){

        Korisnik k = korisnikRepository.findByUsername(username);

        return User.builder()
                .username(k.getUsername())
                .password(k.getPassword())
                .roles("USER")
                .build();
    }
}
