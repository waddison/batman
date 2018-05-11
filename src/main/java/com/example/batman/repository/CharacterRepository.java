package com.example.batman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("characterRepository")
public interface CharacterRepository extends JpaRepository<Character, Long> {
}
