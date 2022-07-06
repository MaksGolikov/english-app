package com.company.holikov.backend.service.impl;

import com.company.holikov.backend.model.Sentence;
import com.company.holikov.backend.model.Student;
import com.company.holikov.backend.pojo.ResultTestRequest;
import com.company.holikov.backend.repository.SentenceRepository;
import com.company.holikov.backend.repository.StudentRepository;
import com.company.holikov.backend.repository.TenseRepository;
import com.company.holikov.backend.service.SentenceService;
import com.company.holikov.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

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
        Map<Long, String> hashMap = resultTestRequest.getMap();
        List<Sentence> allSentences = sentenceRepository.findAllByTense(tenseRepository.findByTense(resultTestRequest.getTense()));
        Map<Integer, String> mapWithAnswer = new LinkedHashMap<>();
        Student byLogin = studentRepository.findByLogin(resultTestRequest.getStudentLogin());

        if(allSentences.size()<hashMap.size()){
            throw new RuntimeException("students answer < all answer");
        }

        int countCorrect = 0;
        for (int i = 0; i < hashMap.size(); i++) {
            for (Long l: hashMap.keySet()) {

                boolean flag = Objects.equals(l, allSentences.get(i).getRightAnswer().getId());
                System.out.println(flag);
                if(flag
                        &&
                        hashMap.get(l).trim().equals(allSentences.get(i).getRightAnswer().getAnswer())){
                    countCorrect++;
                }
            }
            mapWithAnswer.put(allSentences.get(i).getRightAnswer().getId().intValue(), allSentences.get(i).getRightAnswer().getAnswer());

        }

        BigDecimal progress = new BigDecimal(countCorrect)
                .multiply(new BigDecimal(100))
                .divide(new BigDecimal(hashMap.size()), new MathContext(2, RoundingMode.CEILING));

        if (progress.floatValue() > byLogin.getProgress().floatValue()) {
            byLogin.setProgress(progress);
        }
        studentService.update(byLogin);

        return mapWithAnswer;
    }
}
