package com.akkulov.javarush1.java_core.packet5;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture13; Взаимная блокировка
 */
public class Ex8Deadlock {

  static Thread t1 = new T1();
  static Thread t2 = new T2();

  public static void main(String[] args) throws InterruptedException {
    t1.start();
    t2.start();

    t1.interrupt();
  }

  public static class T1 extends Thread {

    @Override
    public void run() {
      try {
        t2.join();
        System.out.println("T1 finished");
      } catch (InterruptedException e) {
        System.out.println("T1 was interrupted");
      }
    }
  }

  public static class T2 extends Thread {

    @Override
    public void run() {
      try {
        t1.join();
        System.out.println("T2 finished");
      } catch (InterruptedException e) {
        System.out.println("T2 was interrupted");
      }
    }
  }
}
