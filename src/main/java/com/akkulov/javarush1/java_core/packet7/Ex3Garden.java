package com.akkulov.javarush1.java_core.packet7;


import java.util.ArrayList;
import java.util.List;

/**
 * https://javarush.com/quests/lectures/questcore.level07.lecture04; Сад-огород
 */
public class Ex3Garden {

  public static void main(String[] args) {

  }

  public static class Garden {

    public final List<String> fruits = new ArrayList<>();
    public final List<String> vegetables = new ArrayList<>();

    public synchronized void addFruit(int index, String fruit) {
      fruits.add(index, fruit);
    }

    public synchronized void addVegetable(int index, String vegetable) {
      vegetables.add(index, vegetable);
    }

    public synchronized void removeFruit(int index) {
      fruits.remove(index);
    }

    public synchronized void removeVegetable(int index) {
      vegetables.remove(index);
    }
  }
}
