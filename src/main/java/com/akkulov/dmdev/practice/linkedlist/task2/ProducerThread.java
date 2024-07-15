package com.akkulov.dmdev.practice.linkedlist.task2;

import java.util.LinkedList;
import java.util.Random;

public class ProducerThread extends Thread {

  private final LinkedList<Integer> integers;

  public ProducerThread(LinkedList<Integer> integers) {
    this.integers = integers;
  }

  @Override
  public void run() {
    produce();
  }

  public void produce() {
    try {
      synchronized (integers) {
        while (true) {
          if (integers.isEmpty()) {
            int randomCycleValue = new Random().nextInt(10) + 1;

            for (int i = 0; i < randomCycleValue; i++) {
              integers.add(randomCycleValue);
            }

            System.out.println(
                getName() + ": Добавили " + randomCycleValue
                    + " новых чисел в хранилище, всего в нем "
                    + integers.size() + " чисел");

            integers.notifyAll();
            integers.wait(2000);
          } else {
            System.out.println(
                getName() + ": Не добавили элементы, хранилище не пустое - " + integers.size()
                    + " элементов");
            integers.wait();
          }

        }

      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
