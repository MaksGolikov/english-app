package com.company.holikov.backend.repository;

import com.company.holikov.backend.model.Tense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenseRepository extends JpaRepository<Tense, Long> {
    Tense findByTense(String tense);
}
