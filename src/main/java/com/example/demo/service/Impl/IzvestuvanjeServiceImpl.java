package com.example.demo.service.Impl;


import com.example.demo.model.Exception.IzvestuvanjeNotFoundException;
import com.example.demo.model.Exception.ProfesorNotFoundException;
import com.example.demo.model.Izvestuvanje;
import com.example.demo.model.Profesor;
import com.example.demo.repository.IzvestuvanjeRepository;
import com.example.demo.repository.ProfesorRepository;
import com.example.demo.service.IzvestuvanjeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IzvestuvanjeServiceImpl implements IzvestuvanjeService {

    private final IzvestuvanjeRepository izvestuvanjeRepository;
    private final ProfesorRepository profesorRepository;

    public IzvestuvanjeServiceImpl(IzvestuvanjeRepository izvestuvanjeRepository, ProfesorRepository profesorRepository) {
        this.izvestuvanjeRepository = izvestuvanjeRepository;
        this.profesorRepository = profesorRepository;
    }

    @Override
    public Optional<Izvestuvanje> findById(Long id) {
        return izvestuvanjeRepository.findById(id);
    }

    @Override
    public List<Izvestuvanje> listAll() {
        return izvestuvanjeRepository.findAll();
    }

    @Override
    public Optional<Izvestuvanje> save(String naslov, Long profesorId, String kategorija, String kratokvoved, String celoizvestuvanje) {
        Profesor profesor = this.profesorRepository.findById(profesorId)
                .orElseThrow(() -> new ProfesorNotFoundException(profesorId));
        return Optional.of(this.izvestuvanjeRepository.save(new Izvestuvanje(naslov, profesor, kategorija, kratokvoved, celoizvestuvanje)));
    }

    @Override
    public Optional<Izvestuvanje> edit(Long id, String naslov, Long profesorId, String kategorija, String kratokvoved, String celoizvestuvanje) {
        Izvestuvanje novoizvestuvanje = this.izvestuvanjeRepository.findById(id).orElseThrow(() -> new IzvestuvanjeNotFoundException(id));
        Profesor profesor = this.profesorRepository.findById(profesorId)
                .orElseThrow(() -> new ProfesorNotFoundException(profesorId));

        novoizvestuvanje.setNaslov(naslov);
        novoizvestuvanje.setProfesor(profesor);
        novoizvestuvanje.setKategorija(kategorija);
        novoizvestuvanje.setKratokvoved(kratokvoved);
        novoizvestuvanje.setCeloIzvestuvanje(celoizvestuvanje);

        return Optional.of(this.izvestuvanjeRepository.save(novoizvestuvanje));    }

    @Override
    public void deleteById(Long id) {
        izvestuvanjeRepository.deleteById(id);
    }
}
