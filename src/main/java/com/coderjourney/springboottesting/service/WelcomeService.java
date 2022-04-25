package com.coderjourney.springboottesting.service;

public class WelcomeService {
    public String getWelcomeMessage(String name) {
        return String.format("Welcome %s!", name);
    }
}
