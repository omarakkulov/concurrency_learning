package com.akkulov.javarush1.java_core.packet4;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture10; А без interrupt слабо?
 */
public class Ex4AndWithoutInterruptWeak {

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(new TestThread());
    t.start();
    Thread.sleep(3000);
    ourInterruptMethod();
  }

  public static void ourInterruptMethod() {
    TestThread.IS_INTERRUPTED = true;
  }

  public static class TestThread implements Runnable {

    public volatile static boolean IS_INTERRUPTED = false;

    public void run() {
      try {
        while (!IS_INTERRUPTED) {
          System.out.println("he-he");
          Thread.sleep(500);
        }
      } catch (InterruptedException e) {
      }
    }
  }
}
