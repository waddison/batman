package com.example.batman.controller;

import com.example.batman.model.Character;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("batman/api/v1/")
public class CharacterController {

    @Value("${marvelhash}")
    private String marvelhash;
    @Value("${marvelapikey}")
    private String marvelapikey;
    @Value("${marvelts}")
    private String marvelts;




    @RequestMapping(value = "characters", method = RequestMethod.GET)
    public List<Character> list() throws IOException {
        String marvelURL = "https://gateway.marvel.com:443/v1/public/characters?apikey=" + marvelapikey + "&ts=" + marvelts + "&hash=" + marvelhash;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(marvelURL, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseEntity.getBody());
        JsonNode results = root.path("data").path("results");
        List<Character>characters = new ArrayList<>();
        for(int i = 0; i < results.size(); i++) {
            Character character = mapper.readValue(results.get(i).toString(), Character.class);
            characters.add(character);
        }

        return characters;
    }

    @RequestMapping(value="character/{name}", method = RequestMethod.GET)
    public Character get(@PathVariable String name) throws IOException {
        String marvelURL = "https://gateway.marvel.com:443/v1/public/characters?apikey=" + marvelapikey + "&ts=" + marvelts + "&hash=" + marvelhash;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(marvelURL + "&name=" + name, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseEntity.getBody());
        JsonNode results = root.path("data").path("results");
        Character character = mapper.readValue(results.get(0).toString(), Character.class);

        return character;
    }

}
