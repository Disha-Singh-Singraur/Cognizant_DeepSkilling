package com.cognizant.mockdependencies.repository;

import com.cognizant.mockdependencies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
