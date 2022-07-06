package com.company.holikov.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sentence")
public class Sentence {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "line")
    @NotBlank
    private String line;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rightAnswer")
    private RightAnswer rightAnswer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tense")
    private Tense tense;

    public Sentence(){}

    public Sentence(String line, RightAnswer rightAnswer, Tense tense) {
        this.line = line;
        this.rightAnswer = new RightAnswer(rightAnswer.getId());
        this.tense = new Tense(tense.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public RightAnswer getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(RightAnswer rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public Tense getTense() {
        return tense;
    }

    public void setTense(Tense tense) {
        this.tense = tense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return id.equals(sentence.id) && line.equals(sentence.line) && rightAnswer.equals(sentence.rightAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, line, rightAnswer);
    }
}
