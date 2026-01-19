/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store.model;

import com.erstesrping.store.model.Grad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 *
 * @author darko
 */
@Entity
public class Let {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "od_id")
    private Grad iz;

    @ManyToOne
    @JoinColumn(name = "do_id")
    private Grad ka;

    private LocalDateTime vreme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Grad getIz() {
        return iz;
    }

    public void setIz(Grad iz) {
        this.iz = iz;
    }

    public Grad getKa() {
        return ka;
    }

    public void setKa(Grad ka) {
        this.ka = ka;
    }

    public LocalDateTime getVreme() {
        return vreme;
    }

    public void setVreme(LocalDateTime vreme) {
        this.vreme = vreme;
    }
    
    @Override
    public String toString() {
        return iz + "-" + ka + " " + vreme.toLocalDate();
    }
}