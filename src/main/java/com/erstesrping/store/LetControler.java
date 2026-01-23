/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store;

import com.erstesrping.store.model.Let;
import com.erstesrping.store.service.LetService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    private final LetService letService;

    public LetControler(LetService letService) {
        this.letService = letService;
    }

    @GetMapping
    public List<Let> findAll() {
        return letService.findAll();
    }

    @GetMapping("/filter")
    public List<Let> filter(
            @RequestParam String iz,
            @RequestParam String ka) {
        return letService.filter(iz, ka);
    }

    @GetMapping("/{id}")
    public Let findOne(@PathVariable Long id) throws Exception {
        return letService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Let create(@RequestBody Let let) {
        return letService.create(let);
    }
}
