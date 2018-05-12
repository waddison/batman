package com.example.batman.controller;

import com.example.batman.model.Character;
import com.example.batman.service.CharacterService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("batman/api/v1/")
public class CharacterController {



    @Autowired
    private CharacterService characterService;

    /*@RequestMapping(value = "characters", method = RequestMethod.GET)
    public List<Character> list() throws IOException {
        *//*String marvelURL = "https://gateway.marvel.com:443/v1/public/characters?apikey=" + marvelapikey + "&ts=" + marvelts + "&hash=" + marvelhash;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(marvelURL, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseEntity.getBody());
        JsonNode results = root.path("data").path("results");
        List<Character>characters = new ArrayList<>();
        for(int i = 0; i < results.size(); i++) {
            Character character = mapper.readValue(results.get(i).toString(), Character.class);
            characters.add(character);
        }*//*
        return characters;
    }*/

    @RequestMapping(value="character/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Character> get(@PathVariable String name) throws IOException {
        Character mvChar = characterService.getCharacter(name);
        return new ResponseEntity<>(mvChar,HttpStatus.OK);
    }

}
