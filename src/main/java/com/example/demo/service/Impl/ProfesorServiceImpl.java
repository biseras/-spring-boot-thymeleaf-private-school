package com.example.demo.service.Impl;


import com.example.demo.model.Exception.ProfesorNotFoundException;
import com.example.demo.model.Profesor;
import com.example.demo.repository.ProfesorRepository;
import com.example.demo.service.ProfesorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    private final ProfesorRepository profesorRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    public Optional<Profesor> findById(Long id) {
        return profesorRepository.findById(id);
    }

    @Override
    public List<Profesor> listAll() {
        return profesorRepository.findAll();
    }

    @Override
    public Optional<Profesor> save(String ime, String prezime, String objasnuvanje, String biografija, String obrazovanieirabotnoiskustvo, String datumodkogaraboti, String email) {
        return Optional.of(this.profesorRepository.save(new Profesor(ime, prezime, objasnuvanje, biografija, obrazovanieirabotnoiskustvo, datumodkogaraboti, email)));
    }

    @Override
    public Optional<Profesor> edit(Long id, String ime, String prezime, String objasnuvanje, String biografija, String obrazovanieirabotnoiskustvo, String datumodkogaraboti, String email) {
        Profesor profesor = this.profesorRepository.findById(id).orElseThrow(() -> new ProfesorNotFoundException(id));

        profesor.setIme(ime);
        profesor.setPrezime(prezime);
        profesor.setObjasnuvanje(objasnuvanje);
        profesor.setBiografija(biografija);
        profesor.setObrazovanieirabotnoiskustvo(obrazovanieirabotnoiskustvo);
        profesor.setDatumodkogaraboti(datumodkogaraboti);
        profesor.setEmail(email);

        return Optional.of(this.profesorRepository.save(profesor));    }

    @Override
    public void deleteById(Long id) {
        profesorRepository.deleteById(id);
    }
}
