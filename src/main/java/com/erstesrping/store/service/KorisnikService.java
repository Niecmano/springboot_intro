/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store.service;

import com.erstesrping.store.model.Korisnik;
import com.erstesrping.store.repository.KorisnikRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darko
 */
@Service
@Transactional
public class KorisnikService {
    @Autowired
    private KorisnikRepository repository;
    
    public Korisnik save(Korisnik korisnik) {
        return repository.save(korisnik);
    }

    public Korisnik findByUsername(String name) {
        return repository.findByUsername(name);
    }
    
}
