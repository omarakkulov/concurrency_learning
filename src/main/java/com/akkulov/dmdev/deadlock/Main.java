package com.akkulov.dmdev.deadlock;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    ArrayList<Integer> integers1 = new ArrayList<>();
    ArrayList<Integer> integers2 = new ArrayList<>();

    Thread thread = new Thread(() -> {
      try {
        synchronized (integers1) {
          Thread.sleep(5000);
          synchronized (integers2) {
            integers2.add(1);
          }
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    Thread thread1 = new Thread(() -> {
      try {
        synchronized (integers2) {
          Thread.sleep(5000);
          synchronized (integers1) {
            integers1.add(1);
          }
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    thread.start();
    thread1.start();

    thread.join();
    thread1.join();

    System.out.println("ANIME");
  }
}
