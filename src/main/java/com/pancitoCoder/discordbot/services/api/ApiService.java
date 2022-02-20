package com.pancitoCoder.discordbot.services.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public abstract class ApiService {
    @Autowired
    protected RestTemplate restTemplate;
}
