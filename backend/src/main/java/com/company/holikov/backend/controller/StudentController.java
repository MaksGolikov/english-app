package com.company.holikov.backend.controller;

import com.company.holikov.backend.model.RightAnswer;
import com.company.holikov.backend.model.Sentence;
import com.company.holikov.backend.model.Student;
import com.company.holikov.backend.model.Tense;
import com.company.holikov.backend.pojo.ResultTestRequest;
import com.company.holikov.backend.repository.RightAnswerRepository;
import com.company.holikov.backend.repository.SentenceRepository;
import com.company.holikov.backend.repository.StudentRepository;
import com.company.holikov.backend.repository.TenseRepository;
import com.company.holikov.backend.service.SentenceService;
import com.company.holikov.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SentenceRepository sentenceRepository;

    @Autowired
    private TenseRepository tenseRepository;

    @Autowired
    private SentenceService sentenceService;

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
//    //@PreAuthorize("hasRole('USER')")
    @PreAuthorize("hasAuthority('USER')")
    public Student userAccess() {
        return studentRepository.findByLogin("test");
    }

    @GetMapping(value = "/theory", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('USER')")
    public String getTheory(@RequestBody Tense tense){
        System.out.println(tense);
        Tense byTense = tenseRepository.findByTense(tense.getTense());
        return byTense.getTheory();
    }

    @GetMapping(value = "/testing", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('USER')")
    public Map<Long, String> getSentences(@RequestBody Tense tense){
        List<Sentence> allById = sentenceRepository.findAllByTense(tenseRepository.findByTense(tense.getTense()));
        Map<Long, String> answerIdAndString = new HashMap<>();
        for (Sentence sentence : allById) {
            answerIdAndString.put(sentence.getRightAnswer().getId(), sentence.getLine());
        }
        return answerIdAndString;
    }


    @PostMapping(value = "/check",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('USER')")
    public Map<Integer,String> checkResult(@RequestBody ResultTestRequest resultTestRequest){
        return sentenceService.checkRightAnswer(resultTestRequest);
    }


}
