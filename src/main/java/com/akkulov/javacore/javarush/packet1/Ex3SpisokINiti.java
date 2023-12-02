package com.akkulov.javacore.javarush.packet1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture03.
 */
public class Ex3SpisokINiti {

  public static volatile List<Thread> list = new ArrayList<>(5);

  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      list.add(new Thread(new SpecialThread()));
    }
  }

  public static class SpecialThread implements Runnable {

    public void run() {
      System.out.println("it's a run method inside SpecialThread");
    }
  }
}
