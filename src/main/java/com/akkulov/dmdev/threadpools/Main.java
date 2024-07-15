package com.akkulov.dmdev.threadpools;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    /*
    // Пул из 1 потока
    ExecutorService pool1 = Executors.newSingleThreadExecutor();

    // Пул потоков с задаваемым размером
    ExecutorService pool2 = Executors.newFixedThreadPool(10);

    // Пул потоков кеширующихся, то есть сколько потоков подадим, столько и создастся для работы,
    // но также и стираются с исходом времени вроде как.
    ExecutorService pool3 = Executors.newCachedThreadPool();

    // Например, для выполнения фоновых задач с какой-либо периодичностью
    ScheduledExecutorService pool4 = Executors.newScheduledThreadPool(4);

    // Создается пул потоков, исходя из того, сколько позволяет количество свободных ядер
    // процессора. Короче говоря, машина сама решает, сколько потоков создать в данный момент
    ExecutorService pool5 = Executors.newWorkStealingPool();
     */

    /////////////////////////////////////////////////////////////////////////////////

    test1();
  }

  private static void test1() {
    ExecutorService threadPool = Executors.newFixedThreadPool(10);

    Future<Integer> future = threadPool.submit(() -> {
          System.out.println("MAIN");
          return 1;
        }
    );
  }
}
