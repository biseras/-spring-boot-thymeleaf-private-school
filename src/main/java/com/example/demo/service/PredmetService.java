package com.example.demo.service;

import com.example.demo.model.Predmet;
import com.example.demo.model.Profesor;

import java.util.List;
import java.util.Optional;

public interface PredmetService {
    Optional<Predmet> findById(Long id);
    List<Predmet> listAll();

    Optional<Predmet> save(String ime, List<Long> profesorId, String vovedzapredmetot, String opis);
    Optional<Predmet> edit(Long id, String ime, List<Long> profesorId, String vovedzapredmetot, String opis);


    void deleteById(Long id);
}
