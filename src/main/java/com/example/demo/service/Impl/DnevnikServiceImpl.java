package com.example.demo.service.Impl;

import com.example.demo.model.*;
import com.example.demo.model.Exception.PredmetNotFoundException;
import com.example.demo.model.Exception.UcenikNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.DnevnikService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DnevnikServiceImpl implements DnevnikService {
    private final DnevnikRepository dnevnikRepository;
    private final UcenikRepository ucenikRepository;
    private final PredmetRepository predmetRepository;
    private final PredmetnaUcenikRepository predmetnaUcenikRepository;

    public DnevnikServiceImpl(DnevnikRepository dnevnikRepository, UcenikRepository ucenikRepository, PredmetRepository predmetRepository, PredmetnaUcenikRepository predmetnaUcenikRepository) {
        this.dnevnikRepository = dnevnikRepository;
        this.ucenikRepository = ucenikRepository;
        this.predmetRepository = predmetRepository;
        this.predmetnaUcenikRepository = predmetnaUcenikRepository;
    }

    @Override
    public Optional<Dnevnik> findById(Long id) {
        return dnevnikRepository.findById(id);
    }

    @Override
    public List<Dnevnik> listAll() {
        return dnevnikRepository.findAll();
    }

//    @Override
//    public Optional<Dnevnik> save(Long ucenikId, Long predmetId1, Integer ocenka1, Long predmetId2, Integer ocenka2, Long predmetId3, Integer ocenka3, Long predmetId4, Integer ocenka4, Long predmetId5, Integer ocenka5) {
//        Ucenik ucenik=ucenikRepository.findById(ucenikId).orElseThrow(() -> new UcenikNotFoundException(ucenikId));
//        List<PredmetnaUcenik>predmetinaucenik= new ArrayList<>();
//        Predmet predmet1=predmetRepository.getById(predmetId1);
//        PredmetnaUcenik predmetnaUcenik1=new PredmetnaUcenik(predmet1, ocenka1);
//        predmetinaucenik.add(predmetnaUcenik1);
//        predmetnaUcenikRepository.save(predmetnaUcenik1);
//        Predmet predmet2=predmetRepository.getById(predmetId2);
//        PredmetnaUcenik predmetnaUcenik2=new PredmetnaUcenik(predmet2, ocenka2);
//        predmetinaucenik.add(predmetnaUcenik2);
//        predmetnaUcenikRepository.save(predmetnaUcenik2);
//
//        Predmet predmet3=predmetRepository.getById(predmetId3);
//        PredmetnaUcenik predmetnaUcenik3=new PredmetnaUcenik(predmet3, ocenka3);
//        predmetinaucenik.add(predmetnaUcenik3);
//        predmetnaUcenikRepository.save(predmetnaUcenik3);
//
//        Predmet predmet4=predmetRepository.getById(predmetId4);
//        PredmetnaUcenik predmetnaUcenik4=new PredmetnaUcenik(predmet4, ocenka4);
//        predmetinaucenik.add(predmetnaUcenik4);
//        predmetnaUcenikRepository.save(predmetnaUcenik4);
//
//        Predmet predmet5=predmetRepository.getById(predmetId5);
//        PredmetnaUcenik predmetnaUcenik5=new PredmetnaUcenik(predmet5, ocenka5);
//        predmetinaucenik.add(predmetnaUcenik5);
//        predmetnaUcenikRepository.save(predmetnaUcenik5);
//
//        return Optional.of(this.dnevnikRepository.save(new Dnevnik(ucenik)));    }

//    public Optional<Dnevnik> edit(Long id, List<Long>ucenikId, String ime, String prezime, String datum, String adresa, String email, Long predmetId1, Integer ocenka1, Long predmetId2, Integer ocenka2, Long predmetId3, Integer ocenka3, Long predmetId4, Integer ocenka4, Long predmetId5, Integer ocenka5) {
//        Dnevnik dnevnik = this.dnevnikRepository.findById(id).orElseThrow(() -> new PredmetNotFoundException(id));
//        List<Ucenik> uceniklist=new ArrayList<>();
//        for (int i=0; i<ucenikId.size(); i++) {
//            Ucenik ucenik = ucenikRepository.findById(ucenikId.get(i)).orElseThrow();
//            List<PredmetnaUcenik> predmetinaucenik = new ArrayList<>();
//            Predmet predmet1 = predmetRepository.getById(predmetId1);
//            PredmetnaUcenik predmetnaUcenik1 = new PredmetnaUcenik(predmet1, ocenka1);
//            predmetinaucenik.add(predmetnaUcenik1);
//            predmetnaUcenikRepository.save(predmetnaUcenik1);
//            Predmet predmet2 = predmetRepository.getById(predmetId2);
//            PredmetnaUcenik predmetnaUcenik2 = new PredmetnaUcenik(predmet2, ocenka2);
//            predmetinaucenik.add(predmetnaUcenik2);
//            predmetnaUcenikRepository.save(predmetnaUcenik2);
//
//            Predmet predmet3 = predmetRepository.getById(predmetId3);
//            PredmetnaUcenik predmetnaUcenik3 = new PredmetnaUcenik(predmet3, ocenka3);
//            predmetinaucenik.add(predmetnaUcenik3);
//            predmetnaUcenikRepository.save(predmetnaUcenik3);
//
//            Predmet predmet4 = predmetRepository.getById(predmetId4);
//            PredmetnaUcenik predmetnaUcenik4 = new PredmetnaUcenik(predmet4, ocenka4);
//            predmetinaucenik.add(predmetnaUcenik4);
//            predmetnaUcenikRepository.save(predmetnaUcenik4);
//
//            Predmet predmet5 = predmetRepository.getById(predmetId5);
//            PredmetnaUcenik predmetnaUcenik5 = new PredmetnaUcenik(predmet5, ocenka5);
//            predmetinaucenik.add(predmetnaUcenik5);
//            predmetnaUcenikRepository.save(predmetnaUcenik5);
//            ucenik.setIme(ime);
//            ucenik.setPrezime(prezime);
//            ucenik.setDatum(datum);
//            ucenik.setAdresa(adresa);
//            ucenik.setEmail(email);
//            ucenik.setPredmetinaucenik(predmetinaucenik);
//            uceniklist.add(ucenik);
//        }
//
//        return Optional.of(this.dnevnikRepository.save(new Dnevnik(uceniklist)));
//        }

    @Override
    public void deleteById(Long id) {
        dnevnikRepository.deleteById(id);
    }
}
