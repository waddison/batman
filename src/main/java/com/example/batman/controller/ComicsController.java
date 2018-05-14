package com.example.batman.controller;

import com.example.batman.model.Character;
import com.example.batman.model.Comic;
import com.example.batman.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("batman/api/v1/comic")
public class ComicsController {

    @Autowired
    private ComicService comicService;

    @RequestMapping(value="{ident}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comic> get(@PathVariable String ident) throws IOException {
        int id = Integer.parseInt(ident);
        Comic comic = comicService.getComic(id);
        return new ResponseEntity<>(comic,HttpStatus.OK);
    }
}
