/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store;

import com.erstesrping.store.repository.GradRepository;
import com.erstesrping.store.model.Grad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author darko
 */
@RestController
@RequestMapping("/api/gradovi")
public class GradControler {
        
    @Autowired
    private GradRepository repository;
    
     @GetMapping
    public Iterable findAll() {
        return repository.findAll();
    }

    @GetMapping("/drzava/{drzava}")
    public List findByDrzava(@PathVariable String drzava) {
        return repository.findByDrzava(drzava);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Grad create(@RequestBody Grad grad) {
        return repository.save(grad);
    }

}
