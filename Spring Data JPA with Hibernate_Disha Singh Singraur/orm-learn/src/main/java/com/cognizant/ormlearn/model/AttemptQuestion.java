package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * File 3, Hands on 3: AttemptQuestion Entity for Quiz Domain
 */
@Entity
@Table(name = "quiz_attempt_question")
@Getter
@Setter
@NoArgsConstructor
public class AttemptQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aq_id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aq_at_id")
    private Attempt attempt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aq_qn_id")
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion", fetch = FetchType.EAGER)
    private Set<AttemptOption> attemptOptions;

    public AttemptQuestion(Attempt attempt, Question question) {
        this.attempt = attempt;
        this.question = question;
    }

    @Override
    public String toString() {
        return "AttemptQuestion{id=" + id + "}";
    }
}
