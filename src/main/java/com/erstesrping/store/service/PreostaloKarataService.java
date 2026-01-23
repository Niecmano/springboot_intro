/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store.service;

import com.erstesrping.store.model.PreostaloKarata;
import com.erstesrping.store.repository.PreostaloKarataRepository;
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
public class PreostaloKarataService {
    @Autowired
    private PreostaloKarataRepository repository;
    
    public List<PreostaloKarata> vratiPreostalo(Long let_id){
       return repository.findByLet_id(let_id);
    }

    public PreostaloKarata updatePreostaloKarata(PreostaloKarata pk, Long id) throws Exception {
        repository.findById(id)
                .orElseThrow(Exception::new);
        return repository.save(pk);
    }
    
    public void delete(Long id) throws Exception {
        repository.findById(id)
                .orElseThrow(Exception::new);
        repository.deleteById(id);
    }
}
