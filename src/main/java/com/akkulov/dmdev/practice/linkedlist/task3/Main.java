package com.akkulov.dmdev.practice.linkedlist.task3;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    int[] arr = new int[100_000_000];
    Random random = new Random();

    // Заполнение массива случайными числами от 1 до 300
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(300) + 1;
    }

    // Начало отсчета времени
    long startTime = System.currentTimeMillis();

    int max = findMaxParallel(arr);

    // Вычисление затраченного времени
    long duration = System.currentTimeMillis() - startTime;

    System.out.println("Время исполнения = " + duration);
    System.out.println("Max = " + max);
  }

  public static int findMax(int[] arr) {
    return IntStream.of(arr)
        .max()
        .orElseThrow();
  }

  public static int findMaxParallel(int[] arr) {
    return IntStream.of(arr)
        .parallel()
        .max()
        .orElseThrow();
  }
}
