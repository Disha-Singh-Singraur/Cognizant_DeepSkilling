package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * File 3, Hands on 3: OptionRepository
 */
@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {
}
