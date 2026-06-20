package com.cognizant.mockdependencies.exercise1;

import com.cognizant.mockdependencies.controller.UserController;
import com.cognizant.mockdependencies.model.User;
import com.cognizant.mockdependencies.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerMockServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUserWithMockedService() throws Exception {
        User user = new User(100L, "Alice");
        when(userService.getUserById(100L)).thenReturn(user);

        mockMvc.perform(get("/users/100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"));
    }
}
