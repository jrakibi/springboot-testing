package com.coderjourney.springboottesting.controller;

import com.coderjourney.springboottesting.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
class WelcomeControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WelcomeService welcomeService;

    @Test
    void shouldGetDefaultWelcomeMessage() throws Exception {
        when(welcomeService.getWelcomeMessage("Stranger")).thenReturn("Welcome Stranger!");
        mockMvc.perform(get("/welcome"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome Stranger!")));
    }

    @Test
    void shouldGetCustomMessaage() throws Exception {
        when(welcomeService.getWelcomeMessage("aicha")).thenReturn("Welcome aicha!");
        mockMvc.perform(get("/welcome?name=aicha"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome aicha!"));
    }
}