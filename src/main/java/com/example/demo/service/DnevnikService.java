package com.example.demo.service;

import com.example.demo.model.Dnevnik;

import java.util.List;
import java.util.Optional;

public interface DnevnikService {
    Optional<Dnevnik> findById(Long id);
    List<Dnevnik> listAll();

   // Optional<Dnevnik> edit(Long id, List<Long>ucenikId, String ime, String prezime, String datum, String adresa, String email, Long predmetId1, Integer ocenka1, Long predmetId2, Integer ocenka2, Long predmetId3, Integer ocenka3, Long predmetId4, Integer ocenka4, Long predmetId5, Integer ocenka5);


    void deleteById(Long id);
}
