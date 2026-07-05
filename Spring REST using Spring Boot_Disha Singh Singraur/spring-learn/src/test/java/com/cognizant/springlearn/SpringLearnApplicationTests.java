package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Handout 2: SpringLearnApplicationTests using MockMvc and Spring Boot Test features
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() {
        // Assert that CountryController is loaded successfully (Handout 2, page 6)
        assertNotNull(countryController);
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testGetCountry() throws Exception {
        // Perform GET request for /country (Handout 2, page 6)
        ResultActions actions = mvc.perform(get("/country"));
        
        // Assertions for status, code and name
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.code").exists());
        actions.andExpect(jsonPath("$.code").value("IN"));
        actions.andExpect(jsonPath("$.name").exists());
        actions.andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testGetCountryException() throws Exception {
        // Perform GET request for invalid country code /countries/az (Handout 2, page 6)
        ResultActions actions = mvc.perform(get("/countries/az"));
        
        // Validate HttpStatus.NOT_FOUND (404) returned by @ResponseStatus on CountryNotFoundException
        actions.andExpect(status().isNotFound());
    }
}
