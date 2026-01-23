/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store;

import com.erstesrping.store.model.*;
import com.erstesrping.store.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    private final KorisnikService service;

    public KorisnikControler(KorisnikService service) {
        this.service = service;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public Korisnik register(@RequestBody Korisnik korisnik) {
        korisnik.setPassword(
                passwordEncoder.encode(korisnik.getPassword())
        );
        return service.save(korisnik);
    }

    @GetMapping("/ulogovan")
    public Korisnik nadjiUlogovanog(Authentication authentication) {
        if (authentication == null) return null;
        return service.findByUsername(authentication.getName());
    }
    
    @GetMapping("/userid")
    public Long vratiUserId(Authentication authentication) {
        if (authentication == null) return null;
        return service.findByUsername(authentication.getName()).getId();
    }
}
