package com.example.batman.service;

import com.example.batman.model.Comic;

import java.io.IOException;

public interface ComicService {

    void save(Comic comic);

    //void findAll();

    Comic getComic(int id) throws IOException;
}
