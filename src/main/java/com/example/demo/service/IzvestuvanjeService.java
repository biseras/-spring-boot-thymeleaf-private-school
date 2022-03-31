package com.example.demo.service;


import com.example.demo.model.Izvestuvanje;

import java.util.List;
import java.util.Optional;

public interface IzvestuvanjeService {
    Optional<Izvestuvanje> findById(Long id);
    List<Izvestuvanje> listAll();

    Optional<Izvestuvanje> save(String naslov, Long profesorId, String kategorija, String kratokvoved, String celoizvestuvanje);
    Optional<Izvestuvanje> edit(Long id,  String naslov, Long profesorId,String kategorija, String kratokvoved, String celoizvestuvanje);


    void deleteById(Long id);
}
