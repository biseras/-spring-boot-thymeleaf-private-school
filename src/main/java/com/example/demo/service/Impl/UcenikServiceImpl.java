package com.example.demo.service.Impl;


import com.example.demo.model.Exception.UcenikNotFoundException;
import com.example.demo.model.Ucenik;
import com.example.demo.repository.UcenikRepository;
import com.example.demo.service.UcenikService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UcenikServiceImpl implements UcenikService {
    private final UcenikRepository ucenikRepository;

    public UcenikServiceImpl(UcenikRepository ucenikRepository) {
        this.ucenikRepository = ucenikRepository;
    }

    @Override
    public Optional<Ucenik> findById(Long id) {
        return ucenikRepository.findById(id);
    }

    @Override
    public List<Ucenik> listAll() {
        return ucenikRepository.findAll();
    }

    @Override
    public Optional<Ucenik> save(String ime, String prezime, String datum, String adresa, String email) {
        return Optional.of(this.ucenikRepository.save(new Ucenik(ime, prezime, datum, adresa, email)));
    }

    @Override
    public Optional<Ucenik> edit(Long id, String ime, String prezime, String datum, String adresa, String email) {
        Ucenik ucenik = this.ucenikRepository.findById(id).orElseThrow(() -> new UcenikNotFoundException(id));

        ucenik.setIme(ime);
        ucenik.setPrezime(prezime);
        ucenik.setDatum(datum);
        ucenik.setAdresa(adresa);
        ucenik.setEmail(email);

        return Optional.of(this.ucenikRepository.save(ucenik));
    }

    @Override
    public void deleteById(Long id) {
        ucenikRepository.deleteById(id);
    }
}
