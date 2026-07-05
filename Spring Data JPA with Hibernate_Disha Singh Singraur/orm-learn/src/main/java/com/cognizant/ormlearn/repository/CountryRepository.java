package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * File 1, Hands on 1 & File 2, Hands on 1: CountryRepository
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // File 2, Hands on 1: Search by name containing, default sort (by code)
    List<Country> findByNameContainingOrderByCodeAsc(String name);

    // File 2, Hands on 1: Search by name containing, sorted by name ascending
    List<Country> findByNameContainingOrderByNameAsc(String name);

    // File 2, Hands on 1: Search by name starting with (e.g. 'Z')
    List<Country> findByNameStartingWith(String prefix);
}
