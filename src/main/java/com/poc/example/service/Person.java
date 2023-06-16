package com.poc.example.service;

import lombok.Data;

@Data
public class Person {

    private int id;
    private int age;
    private String name;
    private String gender;

    public Person(int id, int age, String name, String gender) {
        super();
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
    }
}
