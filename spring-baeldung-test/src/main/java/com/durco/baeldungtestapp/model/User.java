package com.durco.baeldungtestapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test-data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    private String id;
    private String name;
    private String surename;
    private int age;


    public User(String name, String surename, int age) {
        this.name = name;
        this.surename = surename;
        this.age = age;
    }

}
