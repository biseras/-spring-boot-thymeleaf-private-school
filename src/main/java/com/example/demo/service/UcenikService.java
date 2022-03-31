package com.example.demo.service;


import com.example.demo.model.Ucenik;

import java.util.List;
import java.util.Optional;

public interface UcenikService {
    Optional<Ucenik> findById(Long id);
    List<Ucenik> listAll();

    Optional<Ucenik> save(String ime, String prezime, String datum, String adresa, String email);
    Optional<Ucenik> edit(Long id, String ime, String prezime, String datum, String adresa, String email);


    void deleteById(Long id);
}
