/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store;

import com.erstesrping.store.repository.KorisnikRepository;
import com.erstesrping.store.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author darko
 */
@RestController
@RequestMapping("/api/user")
public class KorisnikControler {
        
    @Autowired
    private KorisnikRepository repository;    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping
    public Korisnik register(@RequestBody Korisnik korisnik) {
        korisnik.setPassword(
            passwordEncoder.encode(korisnik.getPassword())
        );
        return repository.save(korisnik);
    }
}
