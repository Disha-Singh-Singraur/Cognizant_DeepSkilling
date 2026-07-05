package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * File 3, Hands on 3: Option Entity for Quiz Domain
 */
@Entity
@Table(name = "quiz_option")
@Getter
@Setter
@NoArgsConstructor
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private int id;

    @Column(name = "op_text", length = 200)
    private String text;

    @Column(name = "op_correct")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "op_qn_id")
    private Question question;

    public Option(String text, boolean correct, Question question) {
        this.text = text;
        this.correct = correct;
        this.question = question;
    }

    @Override
    public String toString() {
        return "Option{id=" + id + ", text='" + text + "', correct=" + correct + "}";
    }
}
