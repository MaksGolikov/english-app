package com.company.holikov.backend.controller;

import com.company.holikov.backend.model.Student;
import com.company.holikov.backend.repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

//    @GetMapping("/user")
//    //@PreAuthorize("hasRole('USER')")
//    @PreAuthorize("hasAuthority('USER')")
//    public String userAccess() {
//        System.out.println("+++");
//        return "user API";
//    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
//    //@PreAuthorize("hasRole('USER')")
    @PreAuthorize("hasAuthority('USER')")
    public Student userAccess() {
        return studentRepository.findByLogin("test");
    }


    @GetMapping("/admin")
    //@PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminAccess() {
        System.out.println("---");
        return "admin API";
    }
}
