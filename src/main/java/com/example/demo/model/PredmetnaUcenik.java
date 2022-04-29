package com.example.demo.model;


import javax.persistence.*;

@Entity
public class PredmetnaUcenik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Predmet predmet;
    private Integer ocenka;

    public PredmetnaUcenik() {
    }

    public PredmetnaUcenik(Predmet predmet, Integer ocenka) {
        this.predmet = predmet;
        this.ocenka = ocenka;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Long getId() {
        return id;
    }

    public Integer getOcenka() {
        return ocenka;
    }

    public void setOcenka(Integer ocenka) {
        this.ocenka = ocenka;
    }
}
