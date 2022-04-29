package com.example.demo.service;


import com.example.demo.model.PredmetnaUcenik;
import com.example.demo.model.Ucenik;

import java.util.List;
import java.util.Optional;

public interface UcenikService {
    Optional<Ucenik> findById(Long id);
    List<Ucenik> listAll();

    Optional<Ucenik> save(String ime, String prezime, String datum, String adresa, String email, Long predmetId1, Integer ocenka1, Long predmetId2, Integer ocenka2, Long predmetId3, Integer ocenka3, Long predmetId4, Integer ocenka4, Long predmetId5, Integer ocenka5);
    Optional<Ucenik> edit(Long id, String ime, String prezime, String datum, String adresa, String email, Long predmetId1, Integer ocenka1, Long predmetId2, Integer ocenka2, Long predmetId3, Integer ocenka3, Long predmetId4, Integer ocenka4, Long predmetId5, Integer ocenka5);


    void deleteById(Long id);
}
