package com.example.batman.service;

import com.example.batman.model.Comic;

import java.io.IOException;
import java.util.List;

public interface ComicService {

    void save(Comic comic);

    //void findAll();

    Comic getComic(int id) throws IOException;

    List<Comic> getComics();
}
