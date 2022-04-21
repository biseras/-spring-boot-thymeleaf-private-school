package com.example.demo.service.Impl;

import com.example.demo.model.Exception.IzvestuvanjeNotFoundException;
import com.example.demo.model.Exception.PredmetNotFoundException;
import com.example.demo.model.Exception.ProfesorNotFoundException;
import com.example.demo.model.Izvestuvanje;
import com.example.demo.model.Predmet;
import com.example.demo.model.Profesor;
import com.example.demo.repository.PredmetRepository;
import com.example.demo.repository.ProfesorRepository;
import com.example.demo.service.PredmetService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PredmetServiceImpl implements PredmetService {
    private final PredmetRepository predmetRepository;
    private final ProfesorRepository profesorRepository;

    public PredmetServiceImpl(PredmetRepository predmetRepository, ProfesorRepository profesorRepository) {
        this.predmetRepository = predmetRepository;
        this.profesorRepository = profesorRepository;
    }

    @Override
    public Optional<Predmet> findById(Long id) {
        return predmetRepository.findById(id);
    }

    @Override
    public List<Predmet> listAll() {
        return predmetRepository.findAll();
    }

    @Override
    public Optional<Predmet> save(String ime, List<Long> profesorId, String vovedzapredmetot, String opis) {
        List<Profesor>profesors= new ArrayList<>();
        for (int i=0; i<profesorId.size(); i++)
        {
            Profesor profesor=profesorRepository.findById(profesorId.get(i)).orElseThrow();
            profesors.add(profesor);
        }
        return Optional.of(this.predmetRepository.save(new Predmet(ime, profesors, vovedzapredmetot, opis)));    }

    @Override
    public Optional<Predmet> edit(Long id, String ime, List<Long> profesorId, String vovedzapredmetot, String opis) {
        Predmet predmet = this.predmetRepository.findById(id).orElseThrow(() -> new PredmetNotFoundException(id));
        List<Profesor>profesors= new ArrayList<>();
        for (int i=0; i<profesorId.size(); i++)
        {
            Profesor profesor=profesorRepository.findById(profesorId.get(i)).orElseThrow();
            profesors.add(profesor);
        }

        predmet.setIme(ime);
        predmet.setProfesor(profesors);
        predmet.setVovedzapredmetot(vovedzapredmetot);
        predmet.setOpis(opis);

        return Optional.of(this.predmetRepository.save(predmet));    }

    @Override
    public void deleteById(Long id) {
        predmetRepository.deleteById(id);
    }
}
