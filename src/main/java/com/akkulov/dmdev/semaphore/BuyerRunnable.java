package com.akkulov.dmdev.semaphore;

import java.util.concurrent.Semaphore;

public class BuyerRunnable implements Runnable {

  private final Semaphore cashboxes;

  public BuyerRunnable(Semaphore cashboxes) {
    this.cashboxes = cashboxes;
  }

  @Override
  public void run() {
    try {
      cashboxes.acquire();

      System.out.println(
          "Покупатель " + Thread.currentThread().getName() + " обслуживается в какой-то кассе");

      Thread.sleep(500);

      System.out.println("Покупатель " + Thread.currentThread().getName()
          + " закончил обслуживаться в какой-то кассе");

      cashboxes.release();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
