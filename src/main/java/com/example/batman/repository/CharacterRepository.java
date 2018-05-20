package com.example.batman.repository;

import com.example.batman.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("characterRepository")
public interface CharacterRepository extends JpaRepository<Character, Long> {


    List<Character> findByName(String name);

    Character save(Character character);


}


