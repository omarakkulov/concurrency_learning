package com.akkulov.dmdev.practice.linkedlist.task2;

import java.util.LinkedList;
import java.util.Random;

public class ConsumerThread extends Thread {

  private final LinkedList<Integer> integers;

  public ConsumerThread(LinkedList<Integer> integers) {
    this.integers = integers;
  }

  @Override
  public void run() {
    while (true) {
      consume();
    }
  }

  public void consume() {
    try {
      synchronized (integers) {
        while (true) {
          Random random = new Random();

//          int randomPeriodical = random.nextInt(11) + 1;
          int randomPeriodical = 2000;
          int randomElementCountToDelete = random.nextInt(integers.size()) + 1;

          if (!integers.isEmpty()) {
            for (int i = 0; i < randomElementCountToDelete; i++) {
              integers.removeFirst();
            }

            System.out.println(
                getName() + ": Удалили " + randomElementCountToDelete
                    + " элементов из хранилища, осталось "
                    + integers.size());

            integers.notifyAll();
            integers.wait(randomPeriodical);
          } else {
            System.out.println(getName() + ": Хранилище пустое");
            integers.wait();
          }

        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
