package com.example.batman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {

    @Id
    @GeneratedValue
    private Long myId;

    private int id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;

   @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<OtherUrls> urls = new ArrayList<>();
}
