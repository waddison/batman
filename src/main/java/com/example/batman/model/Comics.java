package com.example.batman.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comics {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long myId;

    @Column(name = "marvComicId")
    private int id;

    private String title;
    private int issueNumber;

    @Column(length = 2000)
    private String description;
    private String isbn;
    private String form;
    private int pageCount;
    private String resourceURI;
    private Date modified;
    //private List<Character> characters;




}
