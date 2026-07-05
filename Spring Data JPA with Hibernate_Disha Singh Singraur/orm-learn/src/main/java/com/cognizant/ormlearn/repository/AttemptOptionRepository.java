package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.AttemptOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * File 3, Hands on 3: AttemptOptionRepository
 */
@Repository
public interface AttemptOptionRepository extends JpaRepository<AttemptOption, Integer> {
}
