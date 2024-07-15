package com.akkulov.dmdev.practice.linkedlist.task2;

import java.util.LinkedList;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    LinkedList<Integer> integers = new LinkedList<>();

    ProducerThread producerThread = new ProducerThread(integers);
    ConsumerThread consumerThread = new ConsumerThread(integers);

    producerThread.start();
    consumerThread.start();

    producerThread.join();
    consumerThread.join();

//    System.out.println();
  }
}
