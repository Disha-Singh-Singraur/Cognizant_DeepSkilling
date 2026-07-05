package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * File 3, Hands on 3: Question Entity for Quiz Domain
 */
@Entity
@Table(name = "quiz_question")
@Getter
@Setter
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qn_id")
    private int id;

    @Column(name = "qn_text", length = 500)
    private String text;

    @Column(name = "qn_score")
    private double score;

    @OneToMany(mappedBy = "question")
    private Set<Option> options;

    public Question(String text, double score) {
        this.text = text;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Question{id=" + id + ", text='" + text + "', score=" + score + "}";
    }
}
