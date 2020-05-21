package com.example.correct.database;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Dictionary {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String word;

    public Integer getId() {
        return id;
    }

    public String getWord() {
        return word;
    }
}
