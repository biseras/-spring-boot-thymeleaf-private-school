package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ucenik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;

    private String prezime;
    private String datum;
    private String adresa;
    private String email;
    @ManyToMany
    private List<PredmetnaUcenik> predmetinaucenik;


    public Ucenik() {
    }

    public Ucenik(String ime, String prezime, String datum, String adresa, String email, List<PredmetnaUcenik> predmetinaucenik) {
        this.ime = ime;
        this.prezime = prezime;
        this.datum = datum;
        this.adresa = adresa;
        this.email = email;
        this.predmetinaucenik = predmetinaucenik;
    }

    public Long getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getImeiPrezime(){
        return getPrezime() + " "+ getIme();
    }
    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<PredmetnaUcenik> getPredmetinaucenik() {
        return predmetinaucenik;
    }

    public void setPredmetinaucenik(List<PredmetnaUcenik> predmetinaucenik) {
        this.predmetinaucenik = predmetinaucenik;
    }
}
