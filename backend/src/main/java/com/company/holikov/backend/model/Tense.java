package com.company.holikov.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name="tense")
public class Tense {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tense", nullable = false, unique = true)
    @NotBlank
    private String tense;

    @Column(name = "theory", columnDefinition = "text")
    @NotBlank
    private String theory;


    public Tense(Long id) {
        this.id = id;
    }

    public Tense(String tense, String theory) {
        this.tense = tense;
        this.theory = theory;
    }

    public Tense(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTense() {
        return tense;
    }

    public void setTense(String tense) {
        this.tense = tense;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tense tense1 = (Tense) o;
        return id.equals(tense1.id) && tense.equals(tense1.tense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tense);
    }
}
