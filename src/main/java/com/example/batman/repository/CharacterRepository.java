package com.example.batman.repository;

import com.example.batman.model.Character;

import java.util.List;


public interface CharacterRepository {


    List<Character> getCharacter(String name);

    void save(Character character);
}

