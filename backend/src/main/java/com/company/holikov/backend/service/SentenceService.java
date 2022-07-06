package com.company.holikov.backend.service;

import com.company.holikov.backend.model.Sentence;
import com.company.holikov.backend.pojo.ResultTestRequest;

import java.util.List;
import java.util.Map;


public interface SentenceService {

    void create(Sentence sentence);

    void update(Sentence sentence);

    void remove(Sentence sentence);

    List<Sentence> findAll();

    Map<Integer, String> checkRightAnswer(ResultTestRequest resultTestRequest);

}
