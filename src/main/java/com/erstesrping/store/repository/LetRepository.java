/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erstesrping.store.repository;

import com.erstesrping.store.model.Let;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author darko
 */
public interface LetRepository extends CrudRepository<Let, Long>{
    List<Let> findByIz_NazivAndKa_Naziv(String izNaziv, String kaNaziv);
    // SELECT l.* from Let l JOIN grad g1 on l.od_id=g1.id JOIN grad g2 on l.ka_id=g2.id WHERE g1.naziv=? AND g2.naziv=?
}
