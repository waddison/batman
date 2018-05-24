package com.example.batman.service;

import com.example.batman.model.Character;

import java.io.IOException;
import java.util.List;

public interface CharacterService {


    void save(Character character);

    Character getCharacter(String name) throws IOException;

    List<Character> getCharacters();
}
