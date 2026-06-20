package com.cognizant.mockdependencies.exercise3;

import com.cognizant.mockdependencies.model.User;
import com.cognizant.mockdependencies.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationMockServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testIntegrationFlowWithMockedService() throws Exception {
        User user = new User(300L, "Charlie");
        when(userService.getUserById(300L)).thenReturn(user);

        mockMvc.perform(get("/users/300"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Charlie"));
    }
}
