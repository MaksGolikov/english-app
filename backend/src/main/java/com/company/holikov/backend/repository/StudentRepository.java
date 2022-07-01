package com.company.holikov.backend.repository;

import com.company.holikov.backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByLogin(String login);

    Student findByEmail(String email);

    Boolean existsByLogin(String string);

    Boolean existsByEmail(String email);
}
