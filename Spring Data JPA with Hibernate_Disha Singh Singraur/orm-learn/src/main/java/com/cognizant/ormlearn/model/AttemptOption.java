package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * File 3, Hands on 3: AttemptOption Entity for Quiz Domain
 */
@Entity
@Table(name = "quiz_attempt_option")
@Getter
@Setter
@NoArgsConstructor
public class AttemptOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ao_id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ao_aq_id")
    private AttemptQuestion attemptQuestion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ao_op_id")
    private Option option;

    @Column(name = "ao_selected")
    private boolean selected;

    public AttemptOption(AttemptQuestion attemptQuestion, Option option, boolean selected) {
        this.attemptQuestion = attemptQuestion;
        this.option = option;
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "AttemptOption{id=" + id + ", selected=" + selected + "}";
    }
}
