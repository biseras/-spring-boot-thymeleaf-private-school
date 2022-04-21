package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Predmet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    @ManyToMany
    private List<Profesor> profesor;
    private String vovedzapredmetot;
    private String opis;

    public Predmet() {
    }

    public Predmet(String ime, List<Profesor> profesor, String vovedzapredmetot, String opis) {
        this.ime = ime;
        this.profesor = profesor;
        this.vovedzapredmetot = vovedzapredmetot;
        this.opis = opis;
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

    public List<Profesor> getProfesor() {
        return profesor;
    }

    public void setProfesor(List<Profesor> profesor) {
        this.profesor = profesor;
    }

    public String getVovedzapredmetot() {
        return vovedzapredmetot;
    }

    public void setVovedzapredmetot(String vovedzapredmetot) {
        this.vovedzapredmetot = vovedzapredmetot;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
