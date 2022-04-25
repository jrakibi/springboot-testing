package com.coderjourney.springboottesting.controller;

import com.coderjourney.springboottesting.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WelcomeControllerUnitTest {

    @Test
    void shouldWelcome() {
        WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
        WelcomeController welcomeController = new WelcomeController(welcomeService);
        when(welcomeService.getWelcomeMessage("Jamal")).thenReturn("Welcome Jamal!");
        assertEquals("Welcome Jamal!", welcomeController.welcome("Jamal"));
    }
}