package com.example.batman.repository;

import com.example.batman.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComicRepository extends JpaRepository<Comic, Long> {

    List<Comic> findById(int id);

    Comic save(Comic comic);
}
