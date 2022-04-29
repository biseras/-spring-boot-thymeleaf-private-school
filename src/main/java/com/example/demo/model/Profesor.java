package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    private String prezime;
    private String objasnuvanje;
    private String biografija;
    private String obrazovanieirabotnoiskustvo;
    private String datumodkogaraboti;
    private String email;

    public Profesor() {
    }

    public Profesor(String ime, String prezime, String objasnuvanje, String biografija, String obrazovanieirabotnoiskustvo, String datumodkogaraboti, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.objasnuvanje = objasnuvanje;
        this.biografija = biografija;
        this.obrazovanieirabotnoiskustvo = obrazovanieirabotnoiskustvo;
        this.datumodkogaraboti = datumodkogaraboti;
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }
    public String getImeiPrezime(){
        return getPrezime() + getIme();
    }

    public String getEmail() {
        return email;
    }

    public String getDatumodkogaraboti() {
        return datumodkogaraboti;
    }

    public void setDatumodkogaraboti(String datumodkogaraboti) {
        this.datumodkogaraboti = datumodkogaraboti;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObrazovanieirabotnoiskustvo() {
        return obrazovanieirabotnoiskustvo;
    }

    public void setObrazovanieirabotnoiskustvo(String obrazovanieirabotnoiskustvo) {
        this.obrazovanieirabotnoiskustvo = obrazovanieirabotnoiskustvo;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Long getId() {
        return id;
    }

    public String getObjasnuvanje() {
        return objasnuvanje;
    }

    public void setObjasnuvanje(String objasnuvanje) {
        this.objasnuvanje = objasnuvanje;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }
}
