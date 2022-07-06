package com.company.holikov.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "rightAnswer")
public class RightAnswer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "answer")
    @NotBlank
    private String answer;

    public RightAnswer(Long id) {
        this.id = id;
    }

    public RightAnswer(){}

    public RightAnswer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RightAnswer that = (RightAnswer) o;
        return id.equals(that.id) && answer.equals(that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answer);
    }
}
