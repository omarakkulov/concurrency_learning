package com.akkulov.javacore.javarush.packet4;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture10; Снова interrupt
 */
public class Ex3AgainInterrupt {

  public static void main(String[] args) throws InterruptedException {
    TestThread thread = new TestThread();
    thread.start();
    thread.interrupt();
  }

  //Add your code below - добавь код ниже
  public static class TestThread extends Thread {
  }
}
