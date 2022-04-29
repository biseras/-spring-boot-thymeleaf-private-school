package com.example.demo.repository;


import com.example.demo.model.Dnevnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnevnikRepository extends JpaRepository<Dnevnik, Long> {
}
