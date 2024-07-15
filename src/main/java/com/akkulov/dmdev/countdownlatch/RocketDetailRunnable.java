package com.akkulov.dmdev.countdownlatch;

import com.akkulov.dmdev.cyclicbarrier.RocketDetail;
import java.util.concurrent.CountDownLatch;

public class RocketDetailRunnable implements Runnable {

  private final CountDownLatch countDownLatch;
  private final RocketDetail rocketDetail;

  public RocketDetailRunnable(CountDownLatch countDownLatch, RocketDetail rocketDetail) {
    this.countDownLatch = countDownLatch;
    this.rocketDetail = rocketDetail;
  }

  @Override
  public void run() {
    System.out.println("ГОТОВИТСЯ ДЕТАЛЬ " + rocketDetail);
    try {
      Thread.sleep(500);
      System.out.println("ДЕТАЛЬ ГОТОВА " + rocketDetail);
      countDownLatch.countDown();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
