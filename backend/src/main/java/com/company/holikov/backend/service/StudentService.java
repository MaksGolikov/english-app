package com.company.holikov.backend.service;

import com.company.holikov.backend.model.Student;

import java.util.List;

public interface StudentService {

    void create(Student student);

    void update(Student student);

    void remove(Student student);

    List<Student> findAll();

    Student findByLogin(String login);

    Student findByEmail(String email);

}
