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
@RequestMapping("batman/api/v1/character")
public class CharacterController {



    @Autowired
    private CharacterService characterService;

    @RequestMapping(value="{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Character> get(@PathVariable String name) throws IOException {
        Character character = characterService.getCharacter(name);
        return new ResponseEntity<>(character, HttpStatus.OK);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Character>> getAll() {
        List<Character> characters = characterService.getCharacters();
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

}
