/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store;

import com.erstesrping.store.model.PreostaloKarata;
import com.erstesrping.store.service.PreostaloKarataService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author darko
 */
@RestController
@RequestMapping("/api/preostalo")
public class PreostaloKarataControler {
    
    private final PreostaloKarataService service;

    public PreostaloKarataControler(PreostaloKarataService service) {
        this.service = service;
    }
    
    @GetMapping("/{let_id}")
    public List<PreostaloKarata> vratiPreostalo(@PathVariable Long let_id){
       return service.vratiPreostalo(let_id);
    }
    
    @PutMapping("/{id}")
    public PreostaloKarata updatePreostaloKarata(@RequestBody PreostaloKarata pk, @PathVariable Long id) throws Exception {
        return service.updatePreostaloKarata(pk, id);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        service.delete(id);
    }
}
