package com.akkulov.dmdev.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class RocketDetailRunnable implements Runnable {

  private final RocketDetail rocketDetail;
  private final CyclicBarrier cyclicBarrier;

  public RocketDetailRunnable(CyclicBarrier cyclicBarrier, RocketDetail rocketDetail) {
    this.cyclicBarrier = cyclicBarrier;
    this.rocketDetail = rocketDetail;
  }

  @Override
  public void run() {
    System.out.println("ГОТОВИТСЯ ДЕТАЛЬ " + rocketDetail);
    try {
      Thread.sleep(500);
      System.out.println("ДЕТАЛЬ ГОТОВА И ОЖИДАЕТ " + rocketDetail);
      cyclicBarrier.await();
      System.out.println("ДЕТАЛЬ ИСПОЛЬЗОВАНА " + rocketDetail);
    } catch (InterruptedException | BrokenBarrierException e) {
      throw new RuntimeException(e);
    }
  }
}
