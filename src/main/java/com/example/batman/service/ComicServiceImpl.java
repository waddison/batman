package com.example.batman.service;

import com.example.batman.model.Comic;
import com.example.batman.repository.ComicRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class ComicServiceImpl implements ComicService {

    @Value("${marvelhash}")
    private String marvelhash;
    @Value("${marvelapikey}")
    private String marvelapikey;
    @Value("${marvelts}")
    private String marvelts;

    @Autowired
    private ComicRepository comicRepository;

    @Override
    public void save(Comic comic) {
        comicRepository.save(comic);
    }

    @Override
    public Comic getComic(int id) throws IOException {

        List<Comic> comics = comicRepository.getComic(id);
        if (comics.isEmpty()) {
            return grabComic(id);
        }
        return comics.get(0);
    }

    private Comic grabComic(int id) throws IOException {
        String marvelURL = "https://gateway.marvel.com:443/v1/public/comics?apikey=" + marvelapikey + "&ts=" + marvelts + "&hash=" + marvelhash;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(marvelURL + "&id=" + id, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseEntity.getBody());
        JsonNode results = root.path("data").path("results");
        Comic comic = mapper.readValue(results.get(0).toString(), Comic.class);
        comicRepository.save(comic);
        System.out.println(comic.toString());
        return comic;
    }
}
