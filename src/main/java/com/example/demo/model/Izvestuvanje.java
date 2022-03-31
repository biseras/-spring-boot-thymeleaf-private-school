package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Izvestuvanje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naslov;
    @ManyToOne
    private Profesor profesor;
    private String kategorija;
    private String kratokvoved;
    private String celoizvestuvanje;

    public Izvestuvanje() {
    }

    public Izvestuvanje(String naslov, Profesor profesor, String kategorija, String kratokvoved, String celoizvestuvanje) {
        this.naslov = naslov;
        this.profesor = profesor;
        this.kategorija = kategorija;
        this.kratokvoved = kratokvoved;
        this.celoizvestuvanje = celoizvestuvanje;
    }

    public Long getId() {
        return id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getKratokvoved() {
        return kratokvoved;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getCeloizvestuvanje() {
        return celoizvestuvanje;
    }

    public void setCeloizvestuvanje(String celoizvestuvanje) {
        this.celoizvestuvanje = celoizvestuvanje;
    }

    public void setKratokvoved(String kratokvoved) {
        this.kratokvoved = kratokvoved;
    }

    public String getCeloIzvestuvanje() {
        return celoizvestuvanje;
    }

    public void setCeloIzvestuvanje(String celoizvestuvanje) {
        this.celoizvestuvanje = celoizvestuvanje;
    }
}