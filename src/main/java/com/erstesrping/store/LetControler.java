/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store;

import com.erstesrping.store.repository.LetRepository;
import com.erstesrping.store.model.Let;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author darko
 */
@RestController
@RequestMapping("/api/letovi")
public class LetControler {

    @Autowired
    private LetRepository letRepository;

    @GetMapping
    public Iterable findAll() {
        return letRepository.findAll();
    }

    @GetMapping("/filter")
    public List<Let> filter(
            @RequestParam String iz,
            @RequestParam String ka) {
        return letRepository.findByIz_NazivAndKa_Naziv(iz, ka);
    }

    @GetMapping("/{id}")
    public Let findOne(@PathVariable Long id) throws Exception {
        return letRepository.findById(id)
                .orElseThrow(Exception::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Let create(@RequestBody Let let) {
        return letRepository.save(let);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        letRepository.findById(id)
                .orElseThrow(Exception::new);
        letRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Let updateLet(@RequestBody Let let, @PathVariable Long id) throws Exception {
        letRepository.findById(id)
                .orElseThrow(Exception::new);
        return letRepository.save(let);
    }
}
