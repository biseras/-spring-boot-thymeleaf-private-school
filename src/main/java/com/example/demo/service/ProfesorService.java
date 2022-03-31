package com.example.demo.service;


import com.example.demo.model.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    Optional<Profesor> findById(Long id);
    List<Profesor> listAll();

    Optional<Profesor> save(String ime, String prezime, String objasnuvanje, String biografija, String obrazovanieirabotnoiskustvo, String datumodkogaraboti, String email);
    Optional<Profesor> edit(Long id, String ime, String prezime, String objasnuvanje, String biografija, String obrazovanieirabotnoiskustvo, String datumodkogaraboti, String email);


    void deleteById(Long id);
}
