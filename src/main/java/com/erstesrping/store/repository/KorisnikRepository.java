/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erstesrping.store.repository;

import com.erstesrping.store.model.*;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author darko
 */
public interface KorisnikRepository extends CrudRepository<Korisnik, Long>{
    Optional<Korisnik> findByUsername(String username);
}
