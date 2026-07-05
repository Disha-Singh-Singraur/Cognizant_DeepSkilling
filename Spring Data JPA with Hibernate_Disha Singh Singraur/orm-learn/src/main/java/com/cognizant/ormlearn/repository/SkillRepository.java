package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * File 2, Hands on 3: SkillRepository
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
