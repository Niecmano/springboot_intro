/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store;

import com.erstesrping.store.model.PreostaloKarata;
import com.erstesrping.store.repository.PreostaloKarataRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author darko
 */
@RestController
@RequestMapping("/api/preostalo")
public class PreostaloKarataControler {
    
    @Autowired
    private PreostaloKarataRepository repository;
    
    @GetMapping("/{let_id}")
    public List<PreostaloKarata> vratiPreostalo(@PathVariable Long let_id){
       return repository.findByLet_id(let_id);
    }
}
