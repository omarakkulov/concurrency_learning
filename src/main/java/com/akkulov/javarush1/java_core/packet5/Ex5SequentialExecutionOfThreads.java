package com.akkulov.javarush1.java_core.packet5;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture13; Последовательные выполнения
 * нитей Ӏ Java Core: 6 уровень, 13 лекция, задача 1
 */
public class Ex5SequentialExecutionOfThreads {

  public volatile static int COUNT = 4;

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < COUNT; i++) {
      new SleepingThread().join();
    }
  }

  public static class SleepingThread extends Thread {

    private static volatile int threadCount = 0;
    private volatile int countdownIndex = COUNT;

    public SleepingThread() {
      super(String.valueOf(++threadCount));
      start();
    }

    public void run() {
      try {
        while (!Thread.currentThread().isInterrupted()) {
          System.out.println(this);
          if (--countdownIndex == 0) {
            return;
          }
          Thread.sleep(10);
        }
      } catch (InterruptedException e) {
        System.out.println("Нить прервана");
      }
    }

    public String toString() {
      return "#" + getName() + ": " + countdownIndex;
    }
  }
}
