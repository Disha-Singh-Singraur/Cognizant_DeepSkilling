package com.cognizant.mockdependencies.exercise2;

import com.cognizant.mockdependencies.model.User;
import com.cognizant.mockdependencies.repository.UserRepository;
import com.cognizant.mockdependencies.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceMockRepositoryTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserWithMockedRepo() {
        User user = new User(200L, "Bob");
        when(userRepository.findById(200L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(200L);

        assertNotNull(result);
        assertEquals("Bob", result.getName());
    }
}
