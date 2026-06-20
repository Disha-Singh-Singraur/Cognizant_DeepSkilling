package com.cognizant.springtest.exercise7;

import com.cognizant.springtest.model.User;
import com.cognizant.springtest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryDataJpaTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        userRepository.save(new User(10L, "Diana"));
        userRepository.save(new User(11L, "Diana"));
        userRepository.save(new User(12L, "Eva"));

        List<User> result = userRepository.findByName("Diana");
        assertEquals(2, result.size());
    }
}
