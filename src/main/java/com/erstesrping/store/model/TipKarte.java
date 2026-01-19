/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store.model;

/**
 *
 * @author darko
 */
import jakarta.persistence.*;

@Entity
public class TipKarte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String prtljag;
    private String dodusl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPrtljag() {
        return prtljag;
    }

    public void setPrtljag(String prtljag) {
        this.prtljag = prtljag;
    }

    public String getDodusl() {
        return dodusl;
    }

    public void setDodusl(String dodusl) {
        this.dodusl = dodusl;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
