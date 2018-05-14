package com.example.batman.service;

import com.example.batman.model.Character;

import java.io.IOException;

public interface CharacterService {


    void save(Character character);

    void findAll();

    Character getCharacter(String name) throws IOException;
}
