package com.akkulov.javarush1.java_core.packet6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://javarush.com/quests/lectures/questcore.level07.lecture02; Вместе быстрее? Ща проверим ;)
 * out
 */
public class Ex2TogetherFasterLetsCheckItOut {

  public static int threadCount = 10;
  public static int[] testArray = new int[1000];

  static {
    for (int i = 0; i < Ex2TogetherFasterLetsCheckItOut.testArray.length; i++) {
      testArray[i] = i;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    StringBuffer expectedResult = new StringBuffer();
    for (int i = 1000 - 1; i >= 0; i--) {
      expectedResult.append(i).append(" ");
    }

    initThreads();

    StringBuffer result = new StringBuffer();
    for (int i = 0; i < testArray.length; i++) {
      result.append(testArray[i]).append(" ");
    }

    System.out.println("Result: " + result);
    System.out.println("Expected: " + expectedResult);
    System.out.println((result.toString()).contentEquals(expectedResult));

    System.out.println(Arrays.toString(testArray));
  }

  public static void initThreads() throws InterruptedException {
    List<Thread> threads = new ArrayList<>(threadCount);
    for (int i = 0; i < threadCount; i++) {
      threads.add(new SortThread());
    }
    for (Thread thread : threads) {
      thread.start();
    }
    for (Thread thread : threads) {
      thread.join();
    }
  }

  public static class SortThread extends Thread {

    @Override
    public void run() {
      sort(testArray);
    }
  }

  public static void sort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] < array[j]) {
          int k = array[i];
          array[i] = array[j];
          array[j] = k;
        }
      }
    }
  }
}
