package com.company.holikov.backend.service.impl;

import com.company.holikov.backend.model.Sentence;
import com.company.holikov.backend.pojo.ResultTestRequest;
import com.company.holikov.backend.repository.SentenceRepository;
import com.company.holikov.backend.repository.StudentRepository;
import com.company.holikov.backend.repository.TenseRepository;
import com.company.holikov.backend.service.SentenceService;
import com.company.holikov.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class SentenceServiceImpl implements SentenceService {

    @Autowired
    private SentenceRepository sentenceRepository;

    @Autowired
    private TenseRepository tenseRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void create(Sentence sentence) {
        sentenceRepository.save(sentence);
    }

    @Override
    public void update(Sentence sentence) {
        sentenceRepository.save(new Sentence(sentence.getLine(), sentence.getRightAnswer(), sentence.getTense()));
    }

    @Override
    public void remove(Sentence sentence) {
        sentenceRepository.delete(sentence);
    }

    @Override
    public List<Sentence> findAll() {
        return sentenceRepository.findAll();
    }

    @Override
    public Map<Integer, String> checkRightAnswer(ResultTestRequest resultTestRequest) {

        List<Sentence> allById = sentenceRepository.findAllByTense(tenseRepository.findByTense(resultTestRequest.getTense()));
        Map<Long, String> hashMap = new LinkedHashMap<>();
        for (Sentence sentence : allById) {
            hashMap.put(sentence.getRightAnswer().getId(), sentence.getLine());
        }
        List<Sentence> allSentences = sentenceRepository.findAllByTense(tenseRepository.findByTense(resultTestRequest.getTense()));
        Map<Integer, String> mapWithAnswer = new LinkedHashMap<>();

        if (allSentences.size() < hashMap.size()) {
            throw new RuntimeException("students answer < all answer");
        }

        for (int i = 0; i < hashMap.size(); i++) {
            mapWithAnswer.put(allSentences.get(i).getRightAnswer().getId().intValue(), allSentences.get(i).getRightAnswer().getAnswer());
        }

        return mapWithAnswer;
    }
}
