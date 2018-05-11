package com.example.batman.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@ToString
@Setter
@Getter
public class OtherUrls {

    @Id
    @GeneratedValue
    private Long id;

    private String url;

    @ManyToOne
    private Character character;


}
