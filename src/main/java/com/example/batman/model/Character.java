package com.example.batman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;


@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    private int id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;
    private List urls;
}
