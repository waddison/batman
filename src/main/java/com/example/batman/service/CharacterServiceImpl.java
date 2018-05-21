package com.example.batman.service;

import com.example.batman.model.Character;
import com.example.batman.repository.CharacterRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service("characterService")
public class CharacterServiceImpl implements CharacterService{

    @Value("${marvelhash}")
    private String marvelhash;
    @Value("${marvelapikey}")
    private String marvelapikey;
    @Value("${marvelts}")
    private String marvelts;

    @Autowired
    private CharacterRepository characterRepository;


    @Override
    public void save(Character character) {

    }

    public void findAll() {

    }

    @Override
    public Character getCharacter(String name) throws IOException {
        List<Character> characters = characterRepository.findByName(name);
        if (characters.isEmpty()) {
            return grabCharacter(name);
        }
        return characters.get(0);
    }

    @Override
    public List<Character> getCharacters() {
        List<Character> characters = characterRepository.findAll();
        return characters;
    }

    private Character grabCharacter(String name) throws IOException {
        String marvelURL = "https://gateway.marvel.com:443/v1/public/characters?apikey=" + marvelapikey + "&ts=" + marvelts + "&hash=" + marvelhash;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(marvelURL + "&name=" + name, String.class);
        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(responseEntity.getBody());
        ArrayNode results = (ArrayNode)root.path("data").path("results");
        Character character = null;
        for(JsonNode node : results) {
            character = mapper.readValue(node.toString(), Character.class);
            characterRepository.save(character);
            System.out.println(character.toString());
        }
        return character;
    }


}

