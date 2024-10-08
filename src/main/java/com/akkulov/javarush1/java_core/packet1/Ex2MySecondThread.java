package com.akkulov.javarush1.java_core.packet1;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture03.
 */
public class Ex2MySecondThread {

  public static void main(String[] args) {
    TestThread thread = new TestThread();
    thread.start();
  }

  public static class TestThread extends Thread {

    static {
      System.out.println("it's a static block inside TestThread");
    }

    @Override
    public void run() {
      System.out.println("it's a run method");
    }
  }
}
