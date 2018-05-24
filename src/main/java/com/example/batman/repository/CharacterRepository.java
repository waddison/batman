package com.example.batman.repository;

import com.example.batman.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {


    List<Character> findByName(String name);

    Character save(Character character);

    List<Character> findAll();


}


