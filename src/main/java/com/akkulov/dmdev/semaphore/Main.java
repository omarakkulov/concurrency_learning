package com.akkulov.dmdev.semaphore;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(4);

    Semaphore semaphore = new Semaphore(3);

    List<BuyerRunnable> collect = Stream.of(
        new BuyerRunnable(semaphore),
        new BuyerRunnable(semaphore),
        new BuyerRunnable(semaphore),
        new BuyerRunnable(semaphore),
        new BuyerRunnable(semaphore),
        new BuyerRunnable(semaphore),
        new BuyerRunnable(semaphore),
        new BuyerRunnable(semaphore)
    ).collect(Collectors.toList());

    collect.forEach(executorService::submit);

    executorService.shutdown();
  }
}
