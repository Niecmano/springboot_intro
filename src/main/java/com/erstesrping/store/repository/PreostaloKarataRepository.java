/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erstesrping.store.repository;

import com.erstesrping.store.model.PreostaloKarata;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author darko
 */
public interface PreostaloKarataRepository extends JpaRepository<PreostaloKarata, Long>{
     List<PreostaloKarata> findByLet_id(Long let_id);
}
