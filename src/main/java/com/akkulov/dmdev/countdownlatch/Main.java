package com.akkulov.dmdev.countdownlatch;

import com.akkulov.dmdev.cyclicbarrier.RocketDetail;
import java.util.EnumSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(RocketDetail.values().length);
    EnumSet<RocketDetail> rocketDetails = EnumSet.allOf(RocketDetail.class);

    ExecutorService threadPool = Executors.newFixedThreadPool(3);
    threadPool.submit(new Rocket(countDownLatch));

    rocketDetails.stream().
        map(rocketDetail -> new RocketDetailRunnable(countDownLatch, rocketDetail))
        .forEach(threadPool::submit);

    threadPool.shutdown();
    threadPool.awaitTermination(10, TimeUnit.HOURS);
  }
}
