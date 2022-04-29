package com.example.demo.service;

import com.example.demo.model.PredmetnaUcenik;

import java.util.List;
import java.util.Optional;

public interface PredmetnaUcenikService {
    Optional<PredmetnaUcenik> findById(Long id);
    List<PredmetnaUcenik> listAll();
}
