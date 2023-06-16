package com.poc.example.model;

import java.util.function.Consumer;

public class TestClass {

    public static void main(String[] args) {
        Consumer con = (Object s) -> {System.out.println(s);};

        con.accept("Puja");
    }
}
