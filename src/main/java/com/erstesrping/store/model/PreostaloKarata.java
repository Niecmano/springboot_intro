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
public class PreostaloKarata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Let let;

    @ManyToOne
    private TipKarte tipKarte;

    private int preostalo;
    private double cena;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Let getLet() {
        return let;
    }

    public void setLet(Let let) {
        this.let = let;
    }

    public TipKarte getTipKarte() {
        return tipKarte;
    }

    public void setTipKarte(TipKarte tipKarte) {
        this.tipKarte = tipKarte;
    }

    public int getPreostalo() {
        return preostalo;
    }

    public void setPreostalo(int preostalo) {
        this.preostalo = preostalo;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
