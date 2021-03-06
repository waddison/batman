package com.example.batman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Entity
@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "mvcharacter")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long myId;

    @Column(name = "marvId")
    private int id;
    private String name;

    @Column(length = 2000)
    private String description;
    private Date modified;
    private String resourceURI;
    private HashMap<String, String> thumbnail = new HashMap<>();


    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "character_Comic",
            joinColumns = {@JoinColumn(name = "marvId")},
            inverseJoinColumns = {@JoinColumn(name = "marvComicId")}
    )
    private List<Comic> comics = new ArrayList<>();*/




   /*@OneToMany(mappedBy = "character", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<OtherUrls> urls = new ArrayList<>();*/


}
