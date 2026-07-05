package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * File 2, Hands on 3 & 6: Skill Entity Class
 */
@Entity
@Table(name = "skill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_id")
    private int id;

    @Column(name = "sk_name", length = 100)
    private String name;

    // Many-to-Many reverse mapping (File 2, Hands on 6)
    @ManyToMany(mappedBy = "skillList")
    private Set<Employee> employeeList;

    @Override
    public String toString() {
        return "Skill{id=" + id + ", name='" + name + "'}";
    }
}
