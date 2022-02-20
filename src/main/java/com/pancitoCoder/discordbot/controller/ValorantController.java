package com.pancitoCoder.discordbot.controller;

import com.pancitoCoder.discordbot.beans.valorant.EventValorantBean;
import com.pancitoCoder.discordbot.services.api.ValorantApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service/valorant-api")
public class ValorantController {

    @Autowired
    private ValorantApiService valorantApiService;

    /*@GetMapping("/events")
    public ResponseEntity<String> getEvents() {
        List<EventValorantBean> events = valorantApiService.getEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }*/
}
