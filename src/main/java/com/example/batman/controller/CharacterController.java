package com.example.batman.controller;

import com.example.batman.model.Character;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("marvel/character/")
public class CharacterController {

    @Value("${marvelhash}")
    private String marvelhash;
    @Value("${marvelapikey}")
    private String marvelapikey;
    @Value("${marvelts}")
    private String marvelts;


    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String list() throws IOException {
        String marvelURL = "https://gateway.marvel.com:443/v1/public/characters?apikey=" + marvelapikey + "&ts=" + marvelts + "&hash=" + marvelhash;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(marvelURL, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseEntity.getBody());
        JsonNode results = root.path("data").path("results");
        Character character = mapper.readValue(results.get(0).toString(), Character.class);

        return character.toString();
    }
}
