package com.akkulov.dmdev.vol;

public class VolatileDemo {

  private static boolean flag = false;

  public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread(() -> {
      while (!flag) {
        System.out.println("Still false");
      }
    });
    thread1.start();
    Thread.sleep(5);

    Thread thread2 = new Thread(() -> {
      flag = true;
      System.out.println("TRUE");
    });
    thread2.start();


  }
}
