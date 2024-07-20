package com.akkulov.javacore.javarush.packet5;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture13; Последовательные выполнения
 * нитей Ӏ Java Core: 6 уровень, 13 лекция, задача 2
 */
public class Ex7SequentialExecutionOfThreads {

  public static MyThread t = new MyThread();
  static String message = "inside main ";

  public static void main(String[] a) throws Exception {
    t.start();
    t.join();

    for (int i = 0; i < 10; i++) {
      System.out.println(message + i);
      sleep();
    }
  }

  public static void sleep() {
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
    }
  }

  static class MyThread extends Thread {

    String message = "inside MyThread ";

    public void run() {
      for (int i = 0; i < 10; i++) {
        System.out.println(message + i);
        Ex7SequentialExecutionOfThreads.sleep();
      }
    }
  }
}
