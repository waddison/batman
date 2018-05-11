package com.example.batman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
    private Long id;

    private String name;
    private String description;
    private Date modified;
    private String resourceURI;

   @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<OtherUrls> urls = new ArrayList<>();
}
