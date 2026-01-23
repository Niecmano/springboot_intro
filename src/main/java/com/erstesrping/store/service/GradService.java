/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store.service;

import com.erstesrping.store.model.Grad;
import com.erstesrping.store.repository.GradRepository;
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
public class GradService {
    @Autowired
    private GradRepository repository;
    
    public List<Grad> findAll() {
        return repository.findAll();
    }

    public List findByDrzava(String drzava) {
        return repository.findByDrzava(drzava);
    }

    public Grad create(Grad grad) {
        return repository.save(grad);
    }
}
