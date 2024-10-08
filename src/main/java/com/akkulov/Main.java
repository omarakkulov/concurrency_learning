package com.akkulov;

import lombok.ToString;

public class Main {

    public static void main(String[] args) {
        try {
            Animal animal = new Animal(1, "asd", "asdads");
            System.out.println(animal);

            throw new RuntimeException();
        } catch (RuntimeException e) {

        }

    }
}

@ToString(of = {"name", "color"})
class Animal {
    int id;
    String name;
    String color;

    public Animal(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
}
