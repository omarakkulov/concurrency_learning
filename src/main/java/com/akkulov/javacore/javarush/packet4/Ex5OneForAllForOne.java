package com.akkulov.javacore.javarush.packet4;

import com.akkulov.javacore.javarush.packet4.Ex3AgainInterrupt.TestThread;
import java.util.ArrayList;
import java.util.List;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture10; Один для всех, все - для
 * одного
 */
public class Ex5OneForAllForOne {

  public static byte threadCount = 3;
  static List<Thread> threads = new ArrayList<>(threadCount);

  public static void main(String[] args) throws InterruptedException {
    initThreadsAndStart();
    Thread.sleep(3000);
    ourInterruptMethod();
  }

  public static void ourInterruptMethod() {
    threads.forEach(Thread::interrupt);
  }

  private static void initThreadsAndStart() {
    Water water = new Water("water");
    for (int i = 0; i < threadCount; i++) {
      threads.add(new Thread(water, "#" + i));
    }

    for (int i = 0; i < threadCount; i++) {
      threads.get(i).start();
    }
  }

  public static class Water implements Runnable {

    private String sharedResource;

    public Water(String sharedResource) {
      this.sharedResource = sharedResource;
    }

    public void run() {
      Thread currentThread = Thread.currentThread();
      String threadName = currentThread.getName();

      try {
        while (!currentThread.isInterrupted()) {
          System.out.println("Объект " + sharedResource + ", нить " + threadName);
          Thread.sleep(1000);
        }
      } catch (InterruptedException e) {
      }
    }
  }
}
