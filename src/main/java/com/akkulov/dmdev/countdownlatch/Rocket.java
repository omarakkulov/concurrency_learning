package com.akkulov.dmdev.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable {

  private final CountDownLatch countDownLatch;

  public Rocket(CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    System.out.println("ЖДЕМ ДЕТАЛИ РАКЕТЫ...");
    try {
      countDownLatch.await();
      System.out.println("ВЗЛЕТАЕМ!");
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
