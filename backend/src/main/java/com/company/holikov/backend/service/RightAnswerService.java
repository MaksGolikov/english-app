package com.company.holikov.backend.service;

import com.company.holikov.backend.model.RightAnswer;
import com.company.holikov.backend.model.Role;

import java.util.List;

public interface RightAnswerService {

    void create(RightAnswer rightAnswer);

    void update(RightAnswer rightAnswer);

    void remove(RightAnswer rightAnswer);

    List<RightAnswer> findAll();
}
