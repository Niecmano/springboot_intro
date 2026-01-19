/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erstesrping.store.repository;

import com.erstesrping.store.model.Grad;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author darko
 */
public interface GradRepository extends CrudRepository<Grad,Long> {
    List<Grad> findByDrzava(String drzava);
}
