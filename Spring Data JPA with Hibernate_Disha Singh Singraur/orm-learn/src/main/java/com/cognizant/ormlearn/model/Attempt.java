package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/**
 * File 3, Hands on 3: Attempt Entity for Quiz Domain
 */
@Entity
@Table(name = "quiz_attempt")
@Getter
@Setter
@NoArgsConstructor
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @Column(name = "at_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "at_us_id")
    private User user;

    @OneToMany(mappedBy = "attempt", fetch = FetchType.EAGER)
    private Set<AttemptQuestion> attemptQuestions;

    public Attempt(User user, Date date) {
        this.user = user;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Attempt{id=" + id + ", date=" + date + "}";
    }
}
