package com.akkulov.javarush1.java_core.packet1;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture03.
 */
public class Ex1MyFirstThread {

  public static void main(String[] args) {
    TestThread task = new TestThread();
    new Thread(task).start();
  }

  public static class TestThread implements Runnable {

    @Override
    public void run() {
      System.out.println("My first thread");
    }
  }
}
