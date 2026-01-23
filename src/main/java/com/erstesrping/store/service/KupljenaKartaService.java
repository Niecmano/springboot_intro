/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store.service;

import com.erstesrping.store.model.KupljenaKarta;
import com.erstesrping.store.repository.KupljenaKartaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darko
 */
@Service
@Transactional
public class KupljenaKartaService {
    
    @Autowired
    private KupljenaKartaRepository repository;

    public KupljenaKarta create(KupljenaKarta karta) {
        return repository.save(karta);
    }

    public List<KupljenaKarta> findByUser(Long user_id) {
        return repository.findByKupac_id(user_id);
    }

    public KupljenaKarta findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
