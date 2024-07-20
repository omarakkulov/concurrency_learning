package com.akkulov.javacore.javarush.packet5;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture13; Рекурсивное создание нитей
 */
public class Ex6RecursiveThreadCreating {

  static int count = 15;
  static volatile int createdThreadCount;

  public static void main(String[] args) {
    System.out.println(new GenerateThread());
  }

  public static class GenerateThread extends Thread {

    public GenerateThread() {
      super(String.valueOf(++createdThreadCount));
      start();
    }

    @Override
    public void run() {
      if (createdThreadCount < count) {
        System.out.println(new GenerateThread());
      }
    }

    @Override
    public String toString() {
      return String.format("%s created", getName());
    }
  }
}
