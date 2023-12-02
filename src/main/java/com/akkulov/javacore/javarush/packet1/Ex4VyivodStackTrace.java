package com.akkulov.javacore.javarush.packet1;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture03.
 */
public class Ex4VyivodStackTrace {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(new SpecialThread());
    thread.start();

    System.out.println("*****************");

    for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
      System.out.println(element);
    }
  }

  public static class SpecialThread implements Runnable {

    @Override
    public void run() {
      for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
        System.out.println(element);
      }
    }
  }
}
