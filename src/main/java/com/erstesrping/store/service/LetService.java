/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store.service;

import com.erstesrping.store.model.Let;
import com.erstesrping.store.repository.LetRepository;
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
public class LetService {
    @Autowired
    private LetRepository letRepository;

    public List<Let> findAll() {
        return letRepository.findAll();
    }

    public List<Let> filter(String iz,String ka) {
        return letRepository.findByIz_NazivAndKa_Naziv(iz, ka);
    }


    public Let findOne(Long id) throws Exception {
        return letRepository.findById(id)
                .orElseThrow(Exception::new);
    }

    public Let create(Let let) {
        return letRepository.save(let);
    }

}
