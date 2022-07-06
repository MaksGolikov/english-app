package com.company.holikov.backend.service.impl;

import com.company.holikov.backend.model.RightAnswer;
import com.company.holikov.backend.repository.RightAnswerRepository;
import com.company.holikov.backend.service.RightAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightAnswerServiceImpl implements RightAnswerService {

    @Autowired
    private RightAnswerRepository rightAnswerRepository;

    @Override
    public void create(RightAnswer rightAnswer) {
        rightAnswerRepository.save(rightAnswer);
    }

    @Override
    public void update(RightAnswer rightAnswer) {
        rightAnswerRepository.save(new RightAnswer(rightAnswer.getAnswer()));
    }

    @Override
    public void remove(RightAnswer rightAnswer) {
        rightAnswerRepository.delete(rightAnswer);
    }

    @Override
    public List<RightAnswer> findAll() {
        return rightAnswerRepository.findAll();
    }
}
