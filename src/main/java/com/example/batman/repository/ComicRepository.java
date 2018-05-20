package com.example.batman.repository;

import com.example.batman.model.Comic;

import java.util.List;

public interface ComicRepository {

    List<Comic> getComic(int id);

    void save(Comic comic);
}
