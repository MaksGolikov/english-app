package com.company.holikov.backend.repository;

import com.company.holikov.backend.model.RightAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RightAnswerRepository extends JpaRepository<RightAnswer, Long> {

    List<RightAnswer> findAllByAnswer(String answer);
}
