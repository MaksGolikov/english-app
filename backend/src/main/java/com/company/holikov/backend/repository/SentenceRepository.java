package com.company.holikov.backend.repository;

import com.company.holikov.backend.model.Sentence;
import com.company.holikov.backend.model.Tense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentenceRepository extends JpaRepository<Sentence, Long> {

    List<Sentence> findAllByTense(Tense tense);
}
