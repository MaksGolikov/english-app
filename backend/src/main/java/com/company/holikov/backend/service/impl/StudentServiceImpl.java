package com.company.holikov.backend.service.impl;

import com.company.holikov.backend.model.Student;
import com.company.holikov.backend.repository.StudentRepository;
import com.company.holikov.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(Student student) {
        System.out.println(student);
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        Student student1 = new Student(
                student.getLogin(),
                student.getPassword(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getRole()
        );
        studentRepository.save(student1);
    }

    @Override
    public void remove(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByLogin(String login) {
        return studentRepository.findByLogin(login);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

}
