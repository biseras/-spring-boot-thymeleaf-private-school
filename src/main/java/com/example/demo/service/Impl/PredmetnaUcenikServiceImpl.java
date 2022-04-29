package com.example.demo.service.Impl;

import com.example.demo.model.PredmetnaUcenik;
import com.example.demo.repository.PredmetnaUcenikRepository;
import com.example.demo.service.PredmetnaUcenikService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PredmetnaUcenikServiceImpl implements PredmetnaUcenikService {
    private final PredmetnaUcenikRepository predmetnaUcenikRepository;

    public PredmetnaUcenikServiceImpl(PredmetnaUcenikRepository predmetnaUcenikRepository) {
        this.predmetnaUcenikRepository = predmetnaUcenikRepository;
    }

    @Override
    public Optional<PredmetnaUcenik> findById(Long id) {
        return predmetnaUcenikRepository.findById(id);
    }

    @Override
    public List<PredmetnaUcenik> listAll() {
        return predmetnaUcenikRepository.findAll();
    }
}
