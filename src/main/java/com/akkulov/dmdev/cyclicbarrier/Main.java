package com.akkulov.dmdev.cyclicbarrier;

import com.akkulov.dmdev.countdownlatch.Rocket;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(RocketDetail.values().length,
        () -> System.out.println("ПУСК!"));

    ExecutorService threadPool = Executors.newFixedThreadPool(10);

    Arrays.stream(RocketDetail.values())
        .map(rocketDetail -> new RocketDetailRunnable(cyclicBarrier, rocketDetail))
        .forEach(threadPool::submit);

    threadPool.shutdown();

  }
}
